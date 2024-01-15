package edu.hust.it3180.billing;

import java.util.Optional;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.billing.fee.RecurringFee;

/**
 * Representing the RecurringFee an apartment has/had.
 */
public interface Subscription {
    RecurringFee fee();
    
    Apartment apartment();
    
    /**
     * The first BillingPeriod this apartment was charged.
     */
    BillingPeriod from();

    /**
     * If this RecurringFee is applied in this BillingPeriod.
     */
    boolean isOngoing();
    
    /**
     * The last (if any) BillingPeriod this apartment was charged.
     */
    Optional<BillingPeriod> to();
    
    /**
     * List of bills issued to this apartment.
     */
    ImmutableList<Bill> bills();
}
