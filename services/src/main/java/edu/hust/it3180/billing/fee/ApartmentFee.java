package edu.hust.it3180.billing.fee;

/**
 * A Fee that apply to each apartment differently. 
 */
public interface ApartmentFee extends Fee {
    FeeFormula formula();
}
