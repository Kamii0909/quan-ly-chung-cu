package edu.hust.it3180.core.billing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.money.MonetaryAmount;

import org.hibernate.annotations.CompositeType;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import edu.hust.it3180.billing.Bill;
import edu.hust.it3180.billing.BillingPeriod;
import edu.hust.it3180.billing.fee.FeeMetadata;
import edu.hust.it3180.billing.payment.Payment;
import edu.hust.it3180.core.billing.fee.Fee;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import io.hypersistence.utils.hibernate.type.money.MonetaryAmountType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class DefaultBill implements Bill {
    @ManyToOne
    @JoinColumn(name = "fee_id")
    private Fee fee;
    @CompositeType(MonetaryAmountType.class)
    private MonetaryAmount amount;
    private MonthlyBillingPeriod period;
    private boolean isSettled;
    private LocalDateTime settledDateTime;
    @Type(value = JsonType.class)
    private List<Payment> payments;
    
    public DefaultBill(Fee fee, MonetaryAmount amount, MonthlyBillingPeriod period) {
        this.fee = fee;
        this.amount = amount;
        this.period = period;
    }
    
    public DefaultBill() {
    }
    
    @Override
    public FeeMetadata fee() {
        return fee.getMetadata();
    }
    
    @Override
    public MonetaryAmount amount() {
        return amount;
    }
    
    @Override
    public BillingPeriod period() {
        return period;
    }
    
    @Override
    public boolean isSettled() {
        return isSettled;
    }
    
    @Override
    public List<Payment> payments() {
        return payments;
    }
    
    @Override
    public Optional<LocalDateTime> settledDate() {
        return Optional.ofNullable(settledDateTime);
    }
    
    public void setFee(Fee fee) {
        this.fee = fee;
    }
    
    public void setAmount(MonetaryAmount amount) {
        this.amount = amount;
    }
    
    public void setPeriod(MonthlyBillingPeriod period) {
        this.period = period;
    }
    
    public void setSettled(boolean isSettled) {
        this.isSettled = isSettled;
    }
    
    public void setSettledDateTime(LocalDateTime settledDateTime) {
        this.settledDateTime = settledDateTime;
    }
    
    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
    
}
