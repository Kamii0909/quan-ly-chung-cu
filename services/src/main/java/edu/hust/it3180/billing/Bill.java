package edu.hust.it3180.billing;

import java.util.List;
import edu.hust.it3180.billing.fee.Fee;
import edu.hust.it3180.billing.payment.Payment;
import edu.hust.it3180.billing.time.BillingPeriod;

/**
 * A bill generated from a fee at the billing period.
 */
public interface Bill {
    Fee fee();
    
    BillingPeriod period();
    
    boolean isSettled();
    
    List<Payment> payments();
}
