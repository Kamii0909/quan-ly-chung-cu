package edu.hust.it3180.core.apartment;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;

import edu.hust.it3180.resident.Resident;
import edu.hust.it3180.resident.Residents;

public class DefaultResidents implements Residents {
    
    public static DefaultResidents asDefaultImpl(Residents rs) {
        if (rs instanceof DefaultResidents drs) {
            return drs;
        }
        return new DefaultResidents(rs.currentResidents());
    }
    
    private List<DefaultResident> residents;
    
    public DefaultResidents() {
    }
    
    public DefaultResidents(List<Resident> residents) {
        this.residents = residents.stream()
            .map(DefaultResident::asDefaultImpl)
            .collect(Collectors.toList());
    }
    
    @Override
    public ImmutableList<Resident> currentResidents() {
        return ImmutableList.copyOf(residents);
    }
    
    @Override
    public int headCount() {
        return residents.size();
    }
    
    public List<DefaultResident> getResidents() {
        return residents;
    }
    
    public void setResidents(List<DefaultResident> residents) {
        this.residents = residents;
    }
    
}
