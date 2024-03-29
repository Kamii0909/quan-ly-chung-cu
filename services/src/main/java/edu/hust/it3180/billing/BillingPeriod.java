package edu.hust.it3180.billing;

import java.time.LocalDate;

/**
 * For the current solution, it is a month. The billing system don't issue bills
 * each day.
 * 
 * @see BillPeriodUtils
 */
public interface BillingPeriod extends Comparable<BillingPeriod> {
    LocalDate from();
    
    LocalDate to();

}
