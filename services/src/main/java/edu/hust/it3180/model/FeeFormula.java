package edu.hust.it3180.model;

import java.util.Date;

public class FeeFormula {
    private Integer feeFormulaId;
    private Date deadline;
    private String description;
    private String amount;
    private String fine;
    private String apartmentId;
    private Integer feeId;

    public Integer getFeeFormulaId() {
        return feeFormulaId;
    }

    public void setFeeFormulaId(Integer feeFormulaId) {
        this.feeFormulaId = feeFormulaId;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getFine() {
        return fine;
    }

    public void setFine(String fine) {
        this.fine = fine;
    }

    public String getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(String apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Integer getFeeId() {
        return feeId;
    }

    public void setFeeId(Integer feeId) {
        this.feeId = feeId;
    }
}
