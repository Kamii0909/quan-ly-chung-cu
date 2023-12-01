package edu.hust.it3180.resident;

import java.net.URI;
import java.util.Optional;

/**
 * basic identification for a single person.
 */
public interface Resident {
    String name();
    
    Optional<String> phone();
    
    Optional<String> email();
    
    /**
     * Căn cước công dân
     */
    Optional<URI> citizenIdentificationCard();
}
