package edu.hust.it3180.core.apartment;

import java.time.LocalDate;

import edu.hust.it3180.resident.ResidencyRecord;
import edu.hust.it3180.resident.Residents;

public class DefaultResidencyRecord implements ResidencyRecord {
    
    private LocalDate from;
    private LocalDate to;
    private DefaultResidents residents;
    
    public DefaultResidencyRecord(LocalDate from, LocalDate to, DefaultResidents residents) {
        this.from = from;
        this.to = to;
        this.residents = residents;
    }
    
    @Override
    public LocalDate from() {
        return from;
    }
    
    @Override
    public LocalDate to() {
        return to;
    }
    
    @Override
    public Residents residents() {
        return residents;
    }
    
}
