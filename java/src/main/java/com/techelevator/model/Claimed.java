package com.techelevator.model;

import java.time.LocalDate;

/**
 * A Claimed record tracks instance ownership.
 * <p>
 * Each record contains a user ID, an instance ID, and the date associated with
 * the ownership change.
 */
public class Claimed {
    /**
     * A foreign key associated with the current claimant of this instance.
     */
    private int userId;
    /**
     * A foreign key associated with the instance being claimed/released. Also the primary key of this table.
     * <p>
     * This value should never be null.
     */
    private String serial;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

}
