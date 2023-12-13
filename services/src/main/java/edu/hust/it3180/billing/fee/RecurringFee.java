package edu.hust.it3180.billing.fee;

public interface RecurringFee extends Fee {
    Duration duration();
    
    enum Duration {
        MONTHLY,
        ANNUAL;
    }
}
