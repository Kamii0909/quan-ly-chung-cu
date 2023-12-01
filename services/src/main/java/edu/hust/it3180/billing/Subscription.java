package edu.hust.it3180.billing;

import java.util.Optional;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.billing.fee.RecurringFee;
import edu.hust.it3180.billing.time.BillingPeriod;

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
     * The last (if any) BillingPeriod this apartment was charged.
     */
    Optional<BillingPeriod> to();
}
