package com.techelevator.model;

import java.util.Date;

public class ProductionRun {
    private int runCode;
    private int productCode;
    private Date productionDate;
    private int volume;
    private String status;
    private String notes;

    public ProductionRun() {
    }

    public int getRunCode() {
        return runCode;
    }

    public void setRunCode(int runCode) {
        this.runCode = runCode;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
