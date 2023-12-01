package edu.hust.it3180.resident;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.google.common.collect.ImmutableList;

/**
 * A record for: 
 * <ul>
 * <li> Who is/was residing here? 
 * <li> The date of their arrival? 
 * </ul>
 */
public interface ContractStatus {
    
    /**
     * Use {@code #residencyRecords()} in favor of this. Failing to properly handle
     * the mutation may lead to data corruption.
     * 
     * @return a mutable list containing the residency records. Changes to the list
     *         will be visible. 
     */
    List<ResidencyRecord> mutableResidencyRecords();
    
    /**
     * Past residents records
     * 
     * @return empty list if none found
     */
    ImmutableList<ResidencyRecord> residencyRecords();
    
    /**
     * @return the current Resident, null if none
     */
    Optional<ResidencyRecord> currentResident();
    
    /**
     * End the current ResidencyRecord at today, append to
     * {@code #residencyRecords()} a new record starting from tomorrow.
     */
    default void changeCurrentResidentNow(Residents newResident) {
        changeCurrentResidentAt(newResident, LocalDate.now());
    }
    
    /**
     * Similar to {@code #changeCurrentResidentNow(Resident)}, but the current
     * ResidencyRecord will end at the specified date.
     */
    void changeCurrentResidentAt(Residents newResident, LocalDate date);
}
