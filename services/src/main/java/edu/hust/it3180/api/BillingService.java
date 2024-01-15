package edu.hust.it3180.api;

import java.time.LocalDate;
import java.util.List;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.billing.Bill;
import edu.hust.it3180.billing.BillingPeriod;

/**
 * The BillingService provides convinient methods built on top of the
 * BillingSystem.
 */
public interface BillingService {
    BillingSystem billingSystem();
    
    /**
     * Return all apartments with unsettled bills that is issued at least {@code n}
     * BillingPeriod ago. Can be used to quickly sort out ones with expired bills
     * from last month, for example.
     * 
     * @apiNote the current BillingPeriod has {@code n = 0}, which means all
     *          apartment with currently unsettled bills of this BillingPeriod.
     */
    List<Apartment> withPendingBills(int n);
    
    /**
     * Return all bills settled in the range (inclusive) for further analytic.
     */
    ImmutableList<Bill> settledBills(LocalDate from, LocalDate to);
    
    /**
     * Return all bills settled in the range (inclusive) for further analytic.
     */
    ImmutableList<Bill> settledBills(BillingPeriod from, BillingPeriod to);
}
