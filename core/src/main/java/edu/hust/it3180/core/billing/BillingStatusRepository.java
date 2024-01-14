package edu.hust.it3180.core.billing;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BillingStatusRepository extends JpaRepository<DefaultApartmentBillingStatus, Long> {
    @Query("""
        SELECT * FROM DefaultApartmentBillingStatus d
        WHERE d.apartment.position.roomId = :position
        """)
    DefaultApartmentBillingStatus findByApartmentPosition(@Param("position") String position);

    @Query("""
        SELECT * FROM DefaultApartmentBillingStatus d
        WHERE d.apartment.position.roomId IN :positions
        """)
    DefaultApartmentBillingStatus findStatusForApartments(@Param("positions") List<Long> positions);
}
