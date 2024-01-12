package edu.hust.it3180.billing;

import java.time.LocalDate;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.billing.fee.Fee;

public interface ApartmentBillingStatus {
    /**
     * A list of fees are currently applied to this apartment. When issuing bills,
     * the billing system would look through this list and generate corresponding
     * bills appropriate with time.
     */
    ImmutableList<? extends Fee> currentFees();
    
    /**
     * All bills (including settled/fully paid) ones billed to this apartment. Note
     * that this is a snapshot of the underlying values, not a view. If for example,
     * more bills are added after this method returns, the returned list won't
     * contain new bills.
     */
    ImmutableList<? extends Bill> bills();
    
    /**
     * Currently unsettled bills. Note that this is a snapshot of the underlying
     * values, not a view. If for example, more bills are added after this method
     * returns, the returned list won't contain new bills.
     */
    ImmutableList<? extends Bill> pendingBills();
    
    /**
     * All subscription tied to this apartment, including concluded ones. Note that
     * this is a snapshot of the underlying values, not a view. If for example, more
     * subscription are added after this method returns, the returned list won't
     * contain new ones.
     */
    ImmutableList<? extends Subscription> subscriptions();
    
    /**
     * All subscription tied to this apartment, only ongoing ones. Note that this is
     * a snapshot of the underlying values, not a view. If for example, more
     * subscription are added after this method returns, the returned list won't
     * contain new ones.
     */
    ImmutableList<? extends Subscription> ongoingSubscription();
    
    /**
     * The last date this Apartment BillingStatus was calculated. Generally serves
     * no purpose, but can be use to cross check with the value returned from
     * {@link edu.hust.it3180.api.BillingSystem BillingSystem}. These 2 values may
     * differ in the following situation:
     * <ol>
     * <li>{@link edu.hust.it3180.api.BillingSystem#issueBills() issueBill} is
     * called.
     * <li>{@code issueBill} got cancelled unexpectedly (for example, power outage).
     * </ol>
     * The above situation requires each {@code issueBill} not in the same database
     * transaction for all apartments, ignore this method if it is the case.
     */
    LocalDate calculatedDate();
    
}
