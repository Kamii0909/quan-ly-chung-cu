package edu.hust.it3180.core.billing;

import java.time.LocalDate;
import java.util.List;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.billing.ApartmentBillingStatus;
import edu.hust.it3180.billing.Bill;
import edu.hust.it3180.billing.Subscription;
import edu.hust.it3180.billing.fee.Fee;
import edu.hust.it3180.core.billing.fee.AppliedFeeDuration;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

public class DefaultApartmentBillingStatus implements ApartmentBillingStatus {

    @OneToMany
    @JoinColumn(name = "fee_id")
    private List<AppliedFeeDuration> fees;
    @OneToMany
    @JoinColumn(name = "bill_id")
    private List<Bill> bills;

    

    @Override
    public ImmutableList<Fee> currentFees() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'currentFees'");
    }

    @Override
    public ImmutableList<Bill> bills() {
        return ImmutableList.copyOf(bills);
    }

    @Override
    public ImmutableList<Bill> pendingBills() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pendingBills'");
    }

    @Override
    public ImmutableList<Subscription> subscriptions() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'subscriptions'");
    }

    @Override
    public ImmutableList<Subscription> ongoingSubscription() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ongoingSubscription'");
    }

    @Override
    public LocalDate calculatedDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculatedDate'");
    }
    
}
