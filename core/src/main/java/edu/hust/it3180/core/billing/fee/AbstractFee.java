package edu.hust.it3180.core.billing.fee;

import org.hibernate.annotations.Type;

import edu.hust.it3180.billing.fee.ApartmentFee;
import edu.hust.it3180.billing.fee.FeeFormula;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;

@MappedSuperclass
public abstract class AbstractFee implements ApartmentFee {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private boolean compulsory;
    @Type(JsonType.class)
    private FeeFormula formula;
    
    public AbstractFee() {
        // JPA
    }
    
    public AbstractFee(boolean compulsory) {
        this.compulsory = compulsory;
    }
    
    public AbstractFee(String description, boolean compulsory, FeeFormula formula) {
        this.description = description;
        this.compulsory = compulsory;
        this.formula = formula;
    }
    
    @Override
    public String description() {
        return description;
    }
    
    @Override
    public boolean isCompulsory() {
        return compulsory;
    }
    
    @Override
    public FeeFormula formula() {
        return formula;
    }
    
}
