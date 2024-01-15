package edu.hust.it3180.core.billing.fee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RecurringFeeRepository extends JpaRepository<DefaultRecurringFee, Long> {
    
}
