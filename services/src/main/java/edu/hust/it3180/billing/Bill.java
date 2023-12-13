package edu.hust.it3180.billing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.money.MonetaryAmount;

import edu.hust.it3180.billing.fee.Fee;
import edu.hust.it3180.billing.payment.Payment;

/**
 * A bill generated from a fee at the billing period.
 */
public interface Bill {
    Fee fee();
    
    MonetaryAmount amount();
    
    BillingPeriod period();
    
    /**
     * Did this bill is paid fully?
     */
    boolean isSettled();
    
    /**
     * All payments that settled this bill.
     */
    List<Payment> payments();
    
    /**
     * The date at this bill is settled. If there are multiple payments, the last
     * payment is the date (or application can define other rules).
     */
    Optional<LocalDateTime> settledDate();
}
