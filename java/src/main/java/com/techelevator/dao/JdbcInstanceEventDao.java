package com.techelevator.dao;

import com.techelevator.model.InstanceEvent;
import com.techelevator.util.InstanceEvents;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JdbcInstanceEventDao implements InstanceEventDao {

    @Override
    public InstanceEvent createRecord(InstanceEvent rec) {
        return null;
    }

    @Override
    public List<InstanceEvent> getMostRecent(int count) {
        return null;
    }

    @Override
    public List<InstanceEvent> getForEvent(InstanceEvents event) {
        return null;
    }
}
