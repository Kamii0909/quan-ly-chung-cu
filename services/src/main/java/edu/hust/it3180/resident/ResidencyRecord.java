package edu.hust.it3180.resident;

import java.time.LocalDate;

/**
 * Information of a single tenant
 */
public interface ResidencyRecord {
    /**
     * @return start date of apartment residency for this tenant.
     */
    LocalDate from();
    
    /**
     * @return final day of residency for this tenant. {@code LocalDate#MAX} if tenant is
     *         currently residing.
     */
    LocalDate to();

    Residents residents();
}
