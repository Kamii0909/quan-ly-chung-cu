package edu.hust.it3180.core.billing.fee;

import edu.hust.it3180.billing.fee.FeeFormula;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "one_time_fee")
public class OneTimeFee extends AbstractFeeMetadata {
    public OneTimeFee() {
        // JPA
    }

    public OneTimeFee(String description, boolean compulsory, FeeFormula formula) {
        super(description, compulsory, formula);
    }
}
