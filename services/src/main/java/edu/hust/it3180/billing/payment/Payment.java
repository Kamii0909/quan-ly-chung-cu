package edu.hust.it3180.billing.payment;

import java.time.LocalDateTime;

import javax.money.MonetaryAmount;

import edu.hust.it3180.Apartment;

/**
 * A Payment is a money transaction from an apartment to the apartment manager.
 */
public interface Payment {
    Apartment apartment();
    
    MonetaryAmount amount();

    LocalDateTime time();
}
