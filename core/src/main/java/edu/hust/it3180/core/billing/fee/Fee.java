package edu.hust.it3180.core.billing.fee;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyDiscriminator;
import org.hibernate.annotations.AnyDiscriminatorValue;
import org.hibernate.annotations.AnyKeyJavaClass;

import edu.hust.it3180.billing.BillingPeriod;
import edu.hust.it3180.billing.fee.FeeMetadata;
import edu.hust.it3180.billing.fee.RecurringFee;
import edu.hust.it3180.core.billing.MonthlyBillingPeriod;
import jakarta.persistence.*;

@Entity
@Table(name = "fees")
public class Fee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Any
    @AnyDiscriminator(DiscriminatorType.STRING)
    @AnyDiscriminatorValue(discriminator = "R", entity = DefaultRecurringFee.class)
    @AnyDiscriminatorValue(discriminator = "O", entity = OneTimeFee.class)
    @AnyKeyJavaClass(Long.class)
    @Column(name = "fee_type")
    @JoinColumn(name = "fee_id")
    private FeeMetadata metadata;
    @Embedded
    @AttributeOverride(name = "month", column = @Column(name = "from_month"))
    @AttributeOverride(name = "year", column = @Column(name = "from_year"))
    private MonthlyBillingPeriod from;
    @Embedded
    @AttributeOverride(name = "month", column = @Column(name = "to_month"))
    @AttributeOverride(name = "year", column = @Column(name = "to_year"))
    private MonthlyBillingPeriod to;
    
    public Fee() {
        // JPA
    }
    
    public Fee(FeeMetadata fee, MonthlyBillingPeriod from, MonthlyBillingPeriod to) {
        this.metadata = fee;
        this.from = from;
        this.to = to;
    }
    
    public boolean isRecurring() {
        return metadata instanceof RecurringFee;
    }
    
    public boolean isCompulsory() {
        return metadata.isCompulsory();
    }
    
    public boolean isCurrentlyApplied() {
        return isApplied(MonthlyBillingPeriod.current());
    }

    public boolean isApplied(BillingPeriod period) {
        return to == null ? true : to.compareTo(period) > 0;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public FeeMetadata getMetadata() {
        return metadata;
    }
    
    public void setMetadata(FeeMetadata fee) {
        this.metadata = fee;
    }
    
    public MonthlyBillingPeriod getFrom() {
        return from;
    }
    
    public void setFrom(MonthlyBillingPeriod from) {
        this.from = from;
    }
    
    public MonthlyBillingPeriod getTo() {
        return to;
    }
    
    public void setTo(MonthlyBillingPeriod to) {
        this.to = to;
    }
}
