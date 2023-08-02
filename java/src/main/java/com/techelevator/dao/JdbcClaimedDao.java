package com.techelevator.dao;

import com.techelevator.model.Claimed;

import java.util.List;

public class JdbcClaimedDao implements ClaimedDao {
    @Override
    public Claimed createRecord(int userId, String serial) {
        return null;
    }

    @Override
    public List<Claimed> getInstancesForUser(int userId) {
        return null;
    }

    @Override
    public Claimed getClaimed(String serial) {
        return null;
    }

    @Override
    public Claimed updateRecord(int userId, String serial) {
        return null;
    }

    @Override
    public int deleteRecord(String serial) {
        return 0;
    }

    @Override
    public int deleteRecordsForUser(int userId) {
        return 0;
    }
}
