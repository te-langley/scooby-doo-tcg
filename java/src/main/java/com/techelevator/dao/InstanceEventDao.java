package com.techelevator.dao;

import com.techelevator.model.InstanceEvent;
import com.techelevator.util.InstanceEvents;

import java.util.List;

public interface InstanceEventDao {

    //==============================================================================
    // CREATE
    //==============================================================================
    InstanceEvent createRecord(InstanceEvent rec);

    //==============================================================================
    // READ
    //==============================================================================
    List<InstanceEvent> getMostRecent(int count);
    List<InstanceEvent> getForEvent(InstanceEvents event);

    //==============================================================================
    // UPDATE
    //==============================================================================

    //==============================================================================
    // DELETE
    //==============================================================================
}
