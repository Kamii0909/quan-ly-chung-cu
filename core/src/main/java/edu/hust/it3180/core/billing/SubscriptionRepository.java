package edu.hust.it3180.core.billing;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscriptionRepository extends JpaRepository<DefaultSubscription, Long> {
    
}
