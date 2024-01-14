package edu.hust.it3180.core;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.api.BillingSystem;
import edu.hust.it3180.billing.ApartmentBillingStatus;
import edu.hust.it3180.billing.Bill;
import edu.hust.it3180.billing.BillingPeriod;
import edu.hust.it3180.billing.fee.FeeMetadata;
import edu.hust.it3180.billing.fee.RecurringFee;
import edu.hust.it3180.billing.payment.Payment;
import edu.hust.it3180.core.apartment.ApartmentRepository;
import edu.hust.it3180.core.apartment.DefaultApartment;
import edu.hust.it3180.core.billing.*;
import edu.hust.it3180.core.billing.fee.*;

public class BillingSystemImpl implements BillingSystem {
    
    private final ApartmentRepository apartmentRepository;
    private final FeeRepository feeRepository;
    private final BillingStatusRepository statusRepository;
    private final BillingSystemMetadataRepository metadataRepository;
    private final BillRepository billRepository;
    private final OneTimeFeeRepository oneTimeFeeRepository;
    private final RecurringFeeRepository recurringFeeRepository;
    
    public BillingSystemImpl(ApartmentRepository apartmentRepository,
        FeeRepository feeRepository,
        BillingStatusRepository statusRepository,
        BillingSystemMetadataRepository metadataRepository,
        BillRepository billRepository,
        OneTimeFeeRepository oneTimeFeeRepository,
        RecurringFeeRepository recurringFeeRepository) {
        this.apartmentRepository = apartmentRepository;
        this.feeRepository = feeRepository;
        this.statusRepository = statusRepository;
        this.metadataRepository = metadataRepository;
        this.billRepository = billRepository;
        this.oneTimeFeeRepository = oneTimeFeeRepository;
        this.recurringFeeRepository = recurringFeeRepository;
    }
    
    @Override
    public void register(Apartment apartment) {
        var da = apartmentRepository.save(DefaultApartment.asDefaultImpl(apartment));
        var dabs = new DefaultApartmentBillingStatus();
        dabs.setApartment(da);
        statusRepository.save(dabs);
    }
    
    @Override
    public void unregister(Apartment apartment) {
        apartmentRepository.delete(DefaultApartment.asDefaultImpl(apartment));
        var dabs = statusRepository.findByApartmentPosition(apartment.position().id());
        statusRepository.delete(dabs);
    }
    
    @Override
    public ImmutableList<Apartment> trackingApartments() {
        return ImmutableList.copyOf(apartmentRepository.findAll());
    }
    
    @Override
    public ApartmentBillingStatus billingStatusFor(Apartment apartment) {
        return statusRepository.findByApartmentPosition(apartment.position().id());
    }
    
    @Override
    public Map<Apartment, ApartmentBillingStatus> billingStatusesForAll() {
        return statusRepository.findAll()
            .stream()
            .collect(ImmutableMap.toImmutableMap(st -> st.getApartment(), Function.identity()));
    }
    
    @Override
    public void issueBills() {
        var lastPeriod = lastCalculated();
        if (lastPeriod.compareTo(MonthlyBillingPeriod.current()) >= 0) {
            return;
        }
        var statuses = statusRepository.findAll();
        for (var billStatus : statuses) {
            for (var period : lastPeriod.nextUntil(MonthlyBillingPeriod.CURRENT)) {
                List<Bill> newBills = calculateBillsFor(billStatus, period);
                billStatus.addBills(newBills);
            }
        }
    }
    
    @Override
    public void settleBill(Bill bill, List<Payment> payments) {
        if (!(bill instanceof DefaultBill db)) {
            throw new IllegalArgumentException("Unknown Bill implementation");
        }
        db.setSettled(true);
        db.setPayments(payments);
        db.setSettledDateTime(LocalDateTime.now());
        billRepository.save(db);
    }
    
    @Override
    public LocalDate lastCalculatedDate() {
        return metadataRepository.findById(BillingSystemMetadata.CURRENT_VERSION)
            .get()
            .lastCalculatedDate();
    }
    
    @Override
    public MonthlyBillingPeriod lastCalculated() {
        return MonthlyBillingPeriod.forLocalDate(lastCalculatedDate());
    }
    
    @Override
    public void applyFee(FeeMetadata fee, Predicate<Apartment> whichApartment) {
        FeeMetadata metadata = switch (fee) {
        case OneTimeFee f -> oneTimeFeeRepository.save(f);
        case RecurringFee f -> recurringFeeRepository.save(f);
        default -> throw new IllegalArgumentException("Unknown FeeMetadata implementation");
        };
        final var internalFee = feeRepository.save(new Fee(metadata, MonthlyBillingPeriod.CURRENT, null));
        var affected = statusRepository.findAll()
            .stream()
            .filter(st -> whichApartment.test(st.getApartment()))
            .toList();
        affected.forEach(st -> st.fees().add(internalFee));

        if (metadata instanceof RecurringFee) {
            DefaultSubscription subscription = new DefaultSubscription();
            
        }
        
        statusRepository.saveAll(affected);
        
    }
    
    @Override
    public ImmutableList<FeeMetadata> ongoingFee(BillingPeriod billingPeriod) {
        if (!(billingPeriod instanceof MonthlyBillingPeriod mbp)) {
            throw new IllegalArgumentException("billingPeriod is not MonthlyBillingPeriod");
        }
        return feeRepository.inBillingPeriod(mbp.year(), mbp.month())
            .stream()
            .map(feed -> feed.getMetadata())
            .collect(ImmutableList.toImmutableList());
    }
    
    @Override
    public void removeFee(Predicate<FeeMetadata> whichFee, BillingPeriod from) {
        if (MonthlyBillingPeriod.current().compareTo(from) >= 0) {
            throw new IllegalArgumentException("Can't remove fee in past BillingPeriod");
        }
        var feeds = feeRepository.findAll().stream()
            .filter(feed -> whichFee.test(feed.getMetadata()))
            .toList();
        // TODO DIRTY CODE, compareTo already checked from is a MonthlyBillingPeriod
        // No runtime problem but this fucking sucks
        feeds.forEach(feed -> feed.setTo((MonthlyBillingPeriod) from));
        feeRepository.saveAll(feeds);
    }
    
    /**
     * Get all new bills for apartments, given the BillingPeriod.
     */
    private List<Bill> calculateBillsFor(DefaultApartmentBillingStatus status, MonthlyBillingPeriod period) {
        return status.fees()
            .stream()
            .filter(fee -> fee.isApplied(period))
            .collect(() -> new ArrayList<>(),
                (list, fee) -> list.add(
                    new DefaultBill(fee, fee.getMetadata().formula().calculate(status.getApartment()), period)),
                (l1, l2) -> l1.addAll(l2));
    }
    
}
