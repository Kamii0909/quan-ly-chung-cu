package edu.hust.it3180.core;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "billing_system_metadata")
public class BillingSystemMetadata {
    public static final Long CURRENT_VERSION = 1L;
    @Id
    @Column(name = "app_version")
    private Long appVersion;
    private LocalDate lastCalculated;
    
    public BillingSystemMetadata() {
        // JPA
    }

    public LocalDate lastCalculatedDate() {
        return lastCalculated;
    }

    public static Long getCurrentVersion() {
        return CURRENT_VERSION;
    }

    public Long getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(Long appVersion) {
        this.appVersion = appVersion;
    }

    public LocalDate getLastCalculated() {
        return lastCalculated;
    }

    public void setLastCalculated(LocalDate lastCalculated) {
        this.lastCalculated = lastCalculated;
    }
}
