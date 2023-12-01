package edu.hust.it3180.billing;

import java.util.List;

import edu.hust.it3180.billing.fee.Fee;

public interface ApartmentBillingStatus {
    /**
     * A list of fees currently apply to this apartment.
     */
    List<Fee> currentFees();
}
