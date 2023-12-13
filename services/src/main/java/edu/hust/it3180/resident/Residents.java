package edu.hust.it3180.resident;

import com.google.common.collect.ImmutableList;

/**
 * An Immutable object holding the resident list for a particular ResidencyRecord. 
 */
public interface Residents {
    ImmutableList<Resident> currentResidents();

    int headCount();
}
