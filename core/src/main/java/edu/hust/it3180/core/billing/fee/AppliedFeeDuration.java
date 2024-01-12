package edu.hust.it3180.core.billing.fee;

import java.util.Optional;

import edu.hust.it3180.billing.BillingPeriod;
import edu.hust.it3180.billing.fee.Fee;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class AppliedFeeDuration {
    @Id
    @GeneratedValue
    private Long id;
    private Fee fee;
    private BillingPeriod from;
    private Optional<BillingPeriod> to;
    
    public AppliedFeeDuration() {
    }
    
    public AppliedFeeDuration(Fee fee, BillingPeriod from, Optional<BillingPeriod> to) {
        this.fee = fee;
        this.from = from;
        this.to = to;
    }

    public Fee getFee() {
        return fee;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public BillingPeriod getFrom() {
        return from;
    }

    public void setFrom(BillingPeriod from) {
        this.from = from;
    }

    public Optional<BillingPeriod> getTo() {
        return to;
    }

    public void setTo(Optional<BillingPeriod> to) {
        this.to = to;
    }
}
