package edu.hust.it3180.core;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billing_system_metadat")
public class BillingSystemMetadata {
    public static final Long CURRENT_VERSION = 1L;
    @Id
    private Long appVersion;
    private LocalDate lastCalculated;
    
    public BillingSystemMetadata() {
        // JPA
    }

    public LocalDate lastCalculatedDate() {
        return lastCalculated;
    }
}
