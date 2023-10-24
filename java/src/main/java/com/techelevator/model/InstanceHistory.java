package com.techelevator.model;

import java.sql.Timestamp;

public class InstanceHistory {

    private int eventId;
    private String instanceSerial;
    private int userId;
    private boolean claimed;
    private Timestamp timestamp;

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getInstanceSerial() {
        return instanceSerial;
    }

    public void setInstanceSerial(String instanceSerial) {
        this.instanceSerial = instanceSerial;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

}
