package edu.hust.it3180;

import com.google.common.collect.ImmutableList;

public interface ApartmentPosition {
    /**
     * A List instead of a single int/Integer to support the usecases where a single
     * room has 2 or more floors, for example certain Penthouses.
     */
    ImmutableList<Integer> floor();
    
    /**
     * An unique String for each apartment in a tower. For example: "1208" or
     * "Penthouse-01". The actual formula is up to implementation, the only
     * requirement is uniqueness.
     * <p>
     * Why this field exists when both {@link #floor()} and {@link #room()} can
     * uniquely define a room? It can be a good key to index, has more compact form,
     * for example, the room in floor 6 can have {@link #room()} returns "Conference
     * Room" and have this method returns "6-C".
     */
    String id();
    
    /**
     * A human readble name for the room, intended to be easily recognizable for the
     * users. Names like "Washing Room" or "Pool" is easier to remember than "A4"
     * and "07". Also for this reason this method returns a String instead of and
     * int/Integer.
     */
    String room();
    
    /**
     * The type of this room, intended to be view and sorted by users. For example,
     * one housing may employ "Luxury" and "Bussiness" room, while other is
     * "Apartment" and "Penthouse".
     * <p>
     * Generally application dependant, can be more restrictive in the future as an
     * enum.
     */
    String type();
}
