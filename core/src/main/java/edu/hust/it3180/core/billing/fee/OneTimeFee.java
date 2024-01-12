package edu.hust.it3180.core.billing.fee;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "one_time_fee")
public class OneTimeFee extends AbstractFee {
    
    public OneTimeFee() {
        // JPA
    }
    
}
