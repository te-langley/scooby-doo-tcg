package com.techelevator.model;

public class Instance {
    /**
     * Randomly generate 6 character string that uniquely identifies the instance.
     */
    private String serial;
    /**
     * The product ID.
     */
    private int productCode;
    /**
     * The production run ID.
     */
    private int productionRun;
    /**
     * This instance's order in the production sequence.
     */
    private int sequence;
    /**
     * Whether this instance has been claimed.  All instances start with a default of false.  This value changes to true upon the first claim and can no longer be modified therafter.
     */
    private boolean locked;

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getProductCode() {
        return productCode;
    }

    public void setProductCode(int productCode) {
        this.productCode = productCode;
    }

    public int getProductionRun() {
        return productionRun;
    }

    public void setProductionRun(int productionRun) {
        this.productionRun = productionRun;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public boolean isLocked() {
        return locked;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    @Override
    public boolean equals(Object obj) {
        Instance instance = (Instance) obj;

        if (this == obj) {
            return true;
        }

//        if (obj == null || getClass() != obj.getClass()) {
//            return false;
//        }

        return this.serial.equals(instance.getSerial()) &&
                this.productCode == instance.getProductCode() &&
                this.productionRun == instance.getProductionRun() &&
                this.sequence == instance.getSequence() &&
                this.locked == instance.isLocked();
    }
}
