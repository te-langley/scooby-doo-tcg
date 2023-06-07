package com.techelevator.model;

public class Instance {
    /**
     * Randomly generate 6 character string that uniquely identifies the instance.
     */
    private String serial;
    /**
     * The product ID.
     */
    private String productCode;
    /**
     * The production run ID.
     */
    private String productionRun;
    /**
     * This instance's order in the production sequence.
     */
    private int sequence;
    /**
     * Whether this instance has been claimed.  All instances start with a default of false.  This value changes to true upon the first claim and can no longer be modified therafter.
     */
    private boolean claimed;

    public String getSerial() {
        return serial;
    }
    public void setSerial(String serial) {
        this.serial = serial;
    }
    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductionRun() {
        return productionRun;
    }
    public void setProductionRun(String productionRun) {
        this.productionRun = productionRun;
    }
    public int getSequence() {
        return sequence;
    }
    public void setSequence(int sequence) {
        this.sequence = sequence;
    }
    public boolean isClaimed() {
        return claimed;
    }
    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }

}
