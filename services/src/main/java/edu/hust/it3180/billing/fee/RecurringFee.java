package edu.hust.it3180.billing.fee;

public interface RecurringFee extends FeeMetadata {
    Duration duration();
    
    enum Duration {
        MONTHLY,
        ANNUAL;
    }
}
