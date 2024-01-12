package edu.hust.it3180.core.billing.fee;

import java.time.LocalDate;
import java.time.YearMonth;

import edu.hust.it3180.billing.BillingPeriod;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable
@Access(value = AccessType.FIELD)
public class MonthlyBillingPeriod implements BillingPeriod {
    private int month;
    private int year;
    @Transient
    private LocalDate from;
    @Transient
    private LocalDate to;
    
    public static BillingPeriod current() {
        return new MonthlyBillingPeriod(YearMonth.now());
    }
    
    private MonthlyBillingPeriod(YearMonth ym) {
        this.from = ym.atDay(1);
        this.to = ym.atEndOfMonth();
        this.month = ym.getMonthValue();
        this.year = ym.getYear();
    }
    
    private MonthlyBillingPeriod(int month, int year) {
        this(YearMonth.of(year, month));
    }
    
    @Override
    public LocalDate from() {
        return from;
    }
    
    @Override
    public LocalDate to() {
        return to;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + month;
        result = prime * result + year;
        result = prime * result + ((from == null) ? 0 : from.hashCode());
        result = prime * result + ((to == null) ? 0 : to.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MonthlyBillingPeriod other = (MonthlyBillingPeriod) obj;
        if (month != other.month)
            return false;
        if (year != other.year)
            return false;
        if (from == null) {
            if (other.from != null)
                return false;
        } else if (!from.equals(other.from))
            return false;
        if (to == null) {
            if (other.to != null)
                return false;
        } else if (!to.equals(other.to))
            return false;
        return true;
    }
    
}
