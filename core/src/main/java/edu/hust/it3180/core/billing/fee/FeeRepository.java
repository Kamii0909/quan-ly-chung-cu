package edu.hust.it3180.core.billing.fee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FeeRepository extends JpaRepository<Fee, Long> {
    @Query(value = """
            SELECT fd FROM Fee fd
            WHERE fd.to.month < :month AND fd.to.year < :year
        """)
    List<Fee> inBillingPeriod(@Param("year") int year, @Param("month") int month);

    @Query("""
            SELECT fd FROM Fee fd
            WHERE fd.metadata IN :feeIds
            """)
    List<Fee> findByFeeId(@Param("feeIds") List<Long> feeIds);
}
