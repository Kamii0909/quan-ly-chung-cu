package edu.hust.it3180.core.billing.fee;

import org.hibernate.annotations.Type;

import edu.hust.it3180.billing.fee.FeeFormula;
import edu.hust.it3180.billing.fee.FeeMetadata;
import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class AbstractFeeMetadata implements FeeMetadata {
    @Id
    @GeneratedValue
    private Long id;
    private String description;
    private boolean compulsory;
    @Type(JsonType.class)
    private FeeFormula formula;
    
    public AbstractFeeMetadata() {
        // JPA
    }
    
    public AbstractFeeMetadata(boolean compulsory) {
        this.compulsory = compulsory;
    }
    
    public AbstractFeeMetadata(String description, boolean compulsory, FeeFormula formula) {
        this.description = description;
        this.compulsory = compulsory;
        this.formula = formula;
    }
    
    public Long getId() {
        return id;
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
