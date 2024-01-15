package edu.hust.it3180.billing.fee;

import java.time.LocalDate;
import java.util.Optional;

import javax.money.MonetaryAmount;

import edu.hust.it3180.Apartment;

/**
 * A BillFormula calculate the amount of money an entity has to pay to settle
 * the bill. For example, each month every apartment has to pay
 * {@code 8,800 VND/m^2} as maintainance fee.
 * <p>
 * Missing bills may incur additional fine after deadline.
 */
public interface FeeFormula {
    /**
     * @return The amount of money to settle this fee
     */
    MonetaryAmount calculate(Apartment apartment);
    
    /**
     * Last day before the charge is considered missed.
     */
    @Deprecated
    Optional<LocalDate> deadline();
    
    MonetaryAmount fine(LocalDate paymentDate);
    
    /**
     * A human readable description of the formula.
     * 
     * @apiNote there is no practical way to force implementions to implement
     *          {@code #toString()}, hence this method.
     */
    String description();
}
