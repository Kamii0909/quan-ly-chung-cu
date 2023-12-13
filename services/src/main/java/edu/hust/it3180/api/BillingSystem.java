package edu.hust.it3180.api;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.billing.ApartmentBillingStatus;
import edu.hust.it3180.billing.Bill;
import edu.hust.it3180.billing.BillingPeriod;
import edu.hust.it3180.billing.fee.Fee;
import edu.hust.it3180.billing.payment.Payment;

/**
 * An explaination of the Billing System.
 * <p>
 * In general, the billing systems tracks fee creation/modification and is
 * solely responsible for creating bills. The minimum threshold for billing is
 * MONTHLY.
 * <p>
 * The billing system is designed to support several usecases, like:
 * <ul>
 * <li>Tracking fees across multiple apartments</li>
 * <li>Adding a new Fee/Recurring Fee/Donation</li>
 * </ul>
 * <p>
 * The Billing system operates independently. Ideally, it can track any Entity,
 * not just Apartment. The uses of Apartment as the central identification
 * mechanism here is in fact, tight coupling. But I have not found a good
 * reasoning to stop using Apartment either, so it is what it is.
 * <p>
 * This Billing system doesnt operate automatically, but BY DEMAND. This is to
 * combat against accidentally clock changes. Imagine suddenly the user set the
 * system clock to 1 month behind. There is no clear boundary nor signal to
 * listen to this event (especially when the application is down). By tracking
 * the last time any batch billing task is done, we can have a stronger time
 * guarantee and more well defined billing time.
 * <p>
 * Implementor is STRONGLY RECOMMENDED to take into account time shift. Failure
 * to do so, tbh, is not fatal, but greatly reduce the stability of the
 * application. Timezones and day light saving are not taken into account as the
 * minimal BillingPeriod is MONTHLY.
 */
public interface BillingSystem {
    
    /**
     * Add a new apartment to the tracking list.
     * <p>
     * For example, a new apartment going from unhabitated (belongs to the manager,
     * no bills issued) to sold (start billing).
     * <p>
     * TODO: Adding RegisterPolicy. For example, the current Billing Period is
     * 2023/12/01 -> 2023/12/31. If a new apartment is registered in 2023/12/15,
     * RegisterPolicy will handle what will happen with current running fees, which
     * one is applied, for example.
     */
    void register(Apartment apartment);
    
    /**
     * TODO: Adding UnregisterPolicy.
     * 
     * @see #register(Apartment)
     */
    void unregister(Apartment apartment);
    
    /**
     * Returns all currently tracked apartments.
     */
    ImmutableList<Apartment> trackingApartments();
    
    /**
     * Return the Billing status for an Apartment.
     */
    ApartmentBillingStatus billingStatusFor(Apartment apartment);
    
    /**
     * Return the billing status for all {@link #trackingApartments()}.
     */
    Map<Apartment, ApartmentBillingStatus> billingStatusesForAll();
    
    /**
     * Issue all bills up to the current BillingPeriod.
     */
    void issueBills();
    
    /**
     * Settle a bill.
     */
    void settleBill(Bill bill, List<Payment> payments);
    
    /**
     * The last time {@link #issueBills()} is completed.
     */
    LocalDate lastCalculatedDate();
    
    /**
     * The final Billing Period where all bills are issued.
     */
    BillingPeriod lastCalculated();
    
    /**
     * Apply a new Fee on multiple apartments. New bills are not guaranteed to be
     * issued immediately after this method returns, but it is up to implementation.
     */
    void applyFee(Fee fee, Predicate<Apartment> whichApartment);
    
    /**
     * Returns all Fee currently applied to a specific BillingPeriod.
     */
    ImmutableList<Fee> ongoingFee(BillingPeriod billingPeriod);
}
