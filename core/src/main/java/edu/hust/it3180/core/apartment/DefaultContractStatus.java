package edu.hust.it3180.core.apartment;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.resident.ContractStatus;
import edu.hust.it3180.resident.ResidencyRecord;
import edu.hust.it3180.resident.Residents;
import jakarta.persistence.*;

@Embeddable
public class DefaultContractStatus implements ContractStatus {
    private static final LocalDate FUTURE = LocalDate.of(9999, 1, 1);
    @JdbcTypeCode(value = SqlTypes.JSON)
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
    
    public static LocalDate getFuture() {
        return FUTURE;
    }
    
    public List<DefaultResidencyRecord> getRecords() {
        return records;
    }
    
    public void setRecords(List<DefaultResidencyRecord> records) {
        this.records = records;
    }
    
}
