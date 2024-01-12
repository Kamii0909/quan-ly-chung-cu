package edu.hust.it3180.core.billing.fee;

import edu.hust.it3180.billing.fee.FeeFormula;
import edu.hust.it3180.billing.fee.RecurringFee;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "recurring_fee")
public class DefaultRecurringFee extends AbstractFee implements RecurringFee {
    private Duration duration;

    public DefaultRecurringFee() {
        // JPA
    }

    public DefaultRecurringFee(String description, FeeFormula formula, Duration duration) {
        super(description, true, formula);
        this.duration = duration;
    }
    
    @Override
    public Duration duration() {
        return duration;
    }

    
}
