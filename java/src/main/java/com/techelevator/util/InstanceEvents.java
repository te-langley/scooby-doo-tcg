package com.techelevator.util;

public enum InstanceEvents {

    UNLOCK("First Claim"),
    CLAIM("Re-Claim"),
    RELEASE(""),
    LAUNCH(""),
    CHASE("The Chase is ON!"),
    CHRONO("Around The Sun Bonus"),
    COHORT("% Claimed Bonus"),
    RETIRED("Never Made Again");

    private String description;
    private int low;
    private int high;

    InstanceEvents(String description) {
    }
}
