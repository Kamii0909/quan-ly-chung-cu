package edu.hust.it3180.core;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.api.BillingSystem;
import edu.hust.it3180.billing.ApartmentBillingStatus;
import edu.hust.it3180.billing.Bill;
import edu.hust.it3180.billing.BillingPeriod;
import edu.hust.it3180.billing.fee.Fee;
import edu.hust.it3180.billing.payment.Payment;
import edu.hust.it3180.core.apartment.ApartmentRepository;
import edu.hust.it3180.core.apartment.DefaultApartment;

public class BillingSystemImpl implements BillingSystem {
    
    private final ApartmentRepository apartmentRepository;
    
    public BillingSystemImpl(ApartmentRepository apartmentRepository) {
        this.apartmentRepository = apartmentRepository;
    }
    
    @Override
    public void register(Apartment apartment) {
        apartmentRepository.save(DefaultApartment.asDefaultImpl(apartment));
    }
    
    @Override
    public void unregister(Apartment apartment) {
        apartmentRepository.delete(DefaultApartment.asDefaultImpl(apartment));
    }
    
    @Override
    public ImmutableList<Apartment> trackingApartments() {
        return ImmutableList.copyOf(apartmentRepository.findAll());
    }
    
    @Override
    public ApartmentBillingStatus billingStatusFor(Apartment apartment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'billingStatusFor'");
    }
    
    @Override
    public Map<Apartment, ApartmentBillingStatus> billingStatusesForAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'billingStatusesForAll'");
    }
    
    @Override
    public void issueBills() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'issueBills'");
    }
    
    @Override
    public void settleBill(Bill bill, List<Payment> payments) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'settleBill'");
    }
    
    @Override
    public LocalDate lastCalculatedDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastCalculatedDate'");
    }
    
    @Override
    public BillingPeriod lastCalculated() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'lastCalculated'");
    }
    
    @Override
    public void applyFee(Fee fee, Predicate<Apartment> whichApartment) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyFee'");
    }
    
    @Override
    public ImmutableList<Fee> ongoingFee(BillingPeriod billingPeriod) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ongoingFee'");
    }

    @Override
    public void removeFee(Predicate<Fee> whichFee, BillingPeriod from) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFee'");
    }
    
}
