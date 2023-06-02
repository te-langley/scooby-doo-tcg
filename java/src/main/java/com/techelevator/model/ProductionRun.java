package com.techelevator.model;

import java.util.Date;

public class ProductionRun {
    private int id;
    private int productCode;
    private Date productionDate;
    private int quantity;
    private String status;
    private String notes;

    public ProductionRun() {

    }

    public ProductionRun(int id, int productCode, Date productionDate, int quantity, String status, String notes) {
        this.id = id;
        this.productCode = productCode;
        this.productionDate = productionDate;
        this.quantity = quantity;
        this.status = status;
        this.notes = notes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
