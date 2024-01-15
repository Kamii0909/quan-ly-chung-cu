package edu.hust.it3180.billing;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class BillPeriodUtils {
    private static final MethodHandle MH;
    
    static {
        try {
            MH = MethodHandles
                .publicLookup()
                .findStatic(
                    Class.forName("edu.hust.it3180.core.billing.MonthlyBillingPeriod"),
                    "current",
                    MethodType.methodType(BillingPeriod.class));
        } catch (NoSuchMethodException | IllegalAccessException | ClassNotFoundException e) {
            throw new AssertionError("Wrong configurations", e);
        }
    }
    
    private BillPeriodUtils() {
    }
    
    static BillingPeriod currentBillingPeriod() {
        try {
            return (BillingPeriod) MH.invoke();
        } catch (Throwable e) {
            throw new AssertionError("No way this happened - Ha Trung Kien");
        }
    }
}
