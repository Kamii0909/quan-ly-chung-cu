package edu.hust.it3180.core.apartment;

import edu.hust.it3180.Apartment;
import edu.hust.it3180.ApartmentPosition;
import edu.hust.it3180.resident.ContractStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "apartments")
public class DefaultApartment implements Apartment {
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private DefaultApartmentPosition position;
    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "contract_id")
    private DefaultContractStatus status;
    
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
    
}
