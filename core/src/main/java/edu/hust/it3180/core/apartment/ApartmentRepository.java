package edu.hust.it3180.core.apartment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApartmentRepository extends JpaRepository<DefaultApartment, Long> {
    
}
