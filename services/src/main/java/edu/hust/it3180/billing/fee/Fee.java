package edu.hust.it3180.billing.fee;

/**
 * Money transaction (optional or compulsory) issued and collected by the
 * apartment manager.
 */
public interface Fee {
    String description(); 

    boolean isCompulsory();
}
