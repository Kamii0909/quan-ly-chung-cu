package edu.hust.it3180.core.billing;

import java.util.List;
import java.util.Optional;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.billing.Bill;
import edu.hust.it3180.billing.BillingPeriod;
import edu.hust.it3180.billing.Subscription;
import edu.hust.it3180.billing.fee.RecurringFee;
import edu.hust.it3180.core.billing.fee.Fee;
import jakarta.persistence.*;

@Entity
@Table(name = "subscriptions")
public class DefaultSubscription implements Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "fee_id")
    private Fee fee;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private DefaultApartmentBillingStatus status;
    @AttributeOverride(name = "month", column = @Column(name = "from_month"))
    @AttributeOverride(name = "year", column = @Column(name = "from_year"))
    private MonthlyBillingPeriod from;
    @AttributeOverride(name = "month", column = @Column(name = "to_month"))
    @AttributeOverride(name = "year", column = @Column(name = "to_year"))
    private MonthlyBillingPeriod to;
    @OneToMany
    private List<DefaultBill> bills;
    
    @Override
    public RecurringFee fee() {
        return ((RecurringFee) fee.getMetadata());
    }
    
    @Override
    public Apartment apartment() {
        return status.getApartment();
    }
    
    @Override
    public BillingPeriod from() {
        return from;
    }
    
    @Override
    public boolean isOngoing() {
        return to == null ? true : to.compareTo(MonthlyBillingPeriod.current()) >= 0;
    }
    
    @Override
    public Optional<BillingPeriod> to() {
        return Optional.ofNullable(to);
    }
    
    @Override
    public ImmutableList<Bill> bills() {
        return ImmutableList.copyOf(bills);
    }
    
}
