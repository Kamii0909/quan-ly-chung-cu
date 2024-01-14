package edu.hust.it3180.core.billing;

import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;

import com.google.common.collect.AbstractIterator;

import edu.hust.it3180.billing.BillingPeriod;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Transient;

@Embeddable
@Access(value = AccessType.FIELD)
public class MonthlyBillingPeriod implements BillingPeriod {
    public static final MonthlyBillingPeriod FAR_FUTURE = new MonthlyBillingPeriod(1, 3000);
    public static MonthlyBillingPeriod CURRENT = new MonthlyBillingPeriod(YearMonth.now());
    private int month;
    private int year;
    @Transient
    private LocalDate from;
    @Transient
    private LocalDate to;
    
    public static BillingPeriod current() {
        return CURRENT;
    }
    
    /**
     * Returns the BillingPeriod that {@code date} is in.
     */
    public static MonthlyBillingPeriod forLocalDate(LocalDate date) {
        return new MonthlyBillingPeriod(YearMonth.from(date));
    }
    
    public MonthlyBillingPeriod() {
        // JPA
    }
    
    private MonthlyBillingPeriod(YearMonth ym) {
        this.from = ym.atDay(1);
        this.to = ym.atEndOfMonth();
        this.month = ym.getMonthValue();
        this.year = ym.getYear();
    }
    
    public MonthlyBillingPeriod(int month, int year) {
        this(YearMonth.of(year, month));
    }
    
    public MonthlyBillingPeriod next() {
        return new MonthlyBillingPeriod(YearMonth.of(year, month).plus(Period.ofMonths(1)));
    }
    
    public Iterable<MonthlyBillingPeriod> nextUntil(MonthlyBillingPeriod finalPeriod) {
        return () -> new AbstractIterator<MonthlyBillingPeriod>() {
            private MonthlyBillingPeriod last = finalPeriod;
            
            @Override
            protected MonthlyBillingPeriod computeNext() {
                if (last.compareTo(finalPeriod) >= 0) {
                    endOfData();
                    return null;
                }
                return (last = last.next());
            }
        };
    }
    
    @Override
    public LocalDate from() {
        return from == null ? (from = LocalDate.of(year, month, 1)) : from;
    }
    
    @Override
    public LocalDate to() {
        return to == null ? (to = YearMonth.of(year, month).atEndOfMonth()) : to;
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
    
    @Override
    public int compareTo(BillingPeriod o) {
        if (o instanceof MonthlyBillingPeriod mbp) {
            var yCmp = Integer.compare(this.year, mbp.year);
            return yCmp == 0 ? yCmp : Integer.compare(this.month, mbp.month);
        }
        throw new UnsupportedOperationException("o is not MonthlyBillingPeriod");
    }
    
    public int month() {
        return month;
    }
    
    public int year() {
        return year;
    }
    
}
