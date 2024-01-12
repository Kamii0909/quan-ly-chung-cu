package edu.hust.it3180.core;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import edu.hust.it3180.core.apartment.DefaultApartment;
import edu.hust.it3180.core.billing.DefaultApartmentBillingStatus;

@EnableJpaRepositories(
    basePackageClasses = { DefaultApartment.class, DefaultApartmentBillingStatus.class })
@Configuration
public class CoreConfiguration {
    
}
