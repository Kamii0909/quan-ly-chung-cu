package edu.hust.it3180.core.apartment;

import java.util.List;

import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.Type;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.ApartmentPosition;
import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class DefaultApartmentPosition implements ApartmentPosition {
    @Type(value = ListArrayType.class)
    @Column(columnDefinition = "integer[]")
    private List<Integer> floors;
    @NaturalId
    private String roomId;
    private String room;
    private String type;
    
    public static DefaultApartmentPosition asDefaultImpl(ApartmentPosition ap) {
        if (ap instanceof DefaultApartmentPosition dap) {
            return dap;
        } else {
            return new DefaultApartmentPosition(ap.floor(), ap.id(), ap.room(), ap.type());
        }
    }
    
    
    public DefaultApartmentPosition() {
    }


    public DefaultApartmentPosition(List<Integer> floors, String id, String room, String type) {
        this.floors = floors;
        this.roomId = id;
        this.room = room;
        this.type = type;
    }
    
    @Override
    public ImmutableList<Integer> floor() {
        return ImmutableList.copyOf(floors);
    }
    
    @Override
    public String id() {
        return roomId;
    }
    
    @Override
    public String room() {
        return room;
    }
    
    @Override
    public String type() {
        return type;
    }
    
}
