package edu.hust.it3180.core.billing.fee;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.hust.it3180.billing.fee.RecurringFee;

public interface RecurringFeeRepository extends JpaRepository<RecurringFee, Long> {
    
}
