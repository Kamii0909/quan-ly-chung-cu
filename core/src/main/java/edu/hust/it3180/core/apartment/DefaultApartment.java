package edu.hust.it3180.core.apartment;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.ApartmentPosition;
import edu.hust.it3180.resident.ContractStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "apartments")
public class DefaultApartment implements Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private DefaultApartmentPosition position;
    private DefaultContractStatus status;
    
    public DefaultApartment() {
        // JPA
    }
    
    public static DefaultApartment asDefaultImpl(Apartment apartment) {
        if (apartment instanceof DefaultApartment da) {
            return da;
        } else {
            return new DefaultApartment(apartment);
        }
    }
    
    public DefaultApartment(Apartment apartment) {
        this.position = DefaultApartmentPosition.asDefaultImpl(apartment.position());
    }
    
    @Override
    public ContractStatus status() {
        return status;
    }
    
    @Override
    public ApartmentPosition position() {
        return position;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public DefaultApartmentPosition getPosition() {
        return position;
    }
    
    public void setPosition(DefaultApartmentPosition position) {
        this.position = position;
    }
    
    public DefaultContractStatus getStatus() {
        return status;
    }
    
    public void setStatus(DefaultContractStatus status) {
        this.status = status;
    }
    
}
