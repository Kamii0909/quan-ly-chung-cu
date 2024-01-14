package edu.hust.it3180.core.billing;

import java.time.LocalDate;
import java.util.List;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.billing.ApartmentBillingStatus;
import edu.hust.it3180.billing.Bill;
import edu.hust.it3180.billing.Subscription;
import edu.hust.it3180.billing.fee.FeeMetadata;
import edu.hust.it3180.core.billing.fee.Fee;
import jakarta.persistence.*;

@Entity
@Table(name = "billing_status")
public class DefaultApartmentBillingStatus implements ApartmentBillingStatus {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne(fetch = FetchType.LAZY, orphanRemoval = true)
    @JoinColumn(name = "apartment_id")
    private Apartment apartment;
    @ManyToMany
    @JoinTable(
        name = "billing_status_fees",
        joinColumns = @JoinColumn(name = "fee_id"),
        inverseJoinColumns = @JoinColumn(name = "status_id"))
    private List<Fee> fees;
    @OneToMany
    @JoinColumn(name = "bill_id")
    private List<Bill> bills;
    @OneToMany(mappedBy = "status")
    private List<DefaultSubscription> subscriptions;
    
    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }
    
    public void addBills(List<Bill> newBills) {
        bills.addAll(newBills);
    }
    
    public Apartment getApartment() {
        return apartment;
    }
    
    public List<Fee> fees() {
        return fees;
    }
    
    @Override
    public ImmutableList<FeeMetadata> currentFees() {
        return fees.stream()
            .filter(fee -> fee.isCurrentlyApplied())
            .map(fee -> fee.getMetadata())
            .collect(ImmutableList.toImmutableList());
    }
    
    @Override
    public ImmutableList<Bill> bills() {
        return ImmutableList.copyOf(bills);
    }
    
    @Override
    public ImmutableList<Bill> pendingBills() {
        return bills().stream().filter(bill -> !bill.isSettled()).collect(ImmutableList.toImmutableList());
    }
    
    @Override
    public ImmutableList<Subscription> subscriptions() {
        return ImmutableList.copyOf(subscriptions);
    }
    
    @Override
    public ImmutableList<Subscription> ongoingSubscription() {
        return subscriptions.stream()
            .filter(subs -> subs.isOngoing())
            .collect(ImmutableList.toImmutableList());
    }
    
    @Override
    public LocalDate calculatedDate() {
        throw new UnsupportedOperationException("Unimplemented method 'calculatedDate'");
    }
    
}
