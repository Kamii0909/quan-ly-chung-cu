package edu.hust.it3180.core.apartment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Type;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.resident.ContractStatus;
import edu.hust.it3180.resident.ResidencyRecord;
import edu.hust.it3180.resident.Residents;
import io.hypersistence.utils.hibernate.type.array.ListArrayType;
import jakarta.persistence.*;

@Entity
@Table(name = "contracts")
public class DefaultContractStatus implements ContractStatus {
    private static final LocalDate FUTURE = LocalDate.of(9999, 1, 1);
    @Id
    @GeneratedValue
    private Long id;
    @Type(value = ListArrayType.class)
    @Column(columnDefinition = "jsonb[]")
    private List<DefaultResidencyRecord> records;
    
    @Override
    public List<DefaultResidencyRecord> mutableResidencyRecords() {
        return records;
    }
    
    @Override
    public ImmutableList<ResidencyRecord> residencyRecords() {
        return ImmutableList.copyOf(records);
    }
    
    @Override
    public Optional<DefaultResidencyRecord> currentResident() {
        return records.stream().filter(rr -> rr.to().isAfter(FUTURE)).findAny();
    }
    
    @Override
    public void changeCurrentResidentAt(Residents newResident, LocalDate date) {
        records.add(new DefaultResidencyRecord(date, LocalDate.MAX, DefaultResidents.asDefaultImpl(newResident)));
    }
    
}
