package com.techelevator.model;

import com.techelevator.util.InstanceEvents;

import java.time.LocalDate;

public class InstanceEvent {

    int id;
    String serial;
    int userId;
    InstanceEvents event;
    LocalDate date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public InstanceEvents getEvent() {
        return event;
    }

    public void setEvent(InstanceEvents event) {
        this.event = event;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
