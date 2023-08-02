package com.techelevator.dao;

import com.techelevator.model.Claimed;

import java.util.List;

/**
 * The ClaimedDao is a data access object that tracks the instances that are currently claimed by a user
 */
public interface ClaimedDao {

    Claimed createRecord(int userId, String serial);

    List<Claimed> getInstancesForUser(int userId);

    Claimed getClaimed(String serial);

    Claimed updateRecord(int userId, String serial);

    int deleteRecord(String serial);

    int deleteRecordsForUser(int userId);

}
