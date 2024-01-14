package edu.hust.it3180.core.billing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BillRepository extends JpaRepository<DefaultBill, Long> {
    
}
