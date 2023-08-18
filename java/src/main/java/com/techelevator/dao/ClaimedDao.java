package com.techelevator.dao;

import com.techelevator.model.Claimed;

import java.util.List;

/**
 * The ClaimedDao is a data access object that tracks the instances that are currently claimed by a user
 */
public interface ClaimedDao {

    int createRecord(String serial, int userId);

    List<String> getSerialsForUser(int userId);

    boolean isClaimed(String serial);

    Claimed updateRecord(String serial, int userId);

    int deleteRecord(String serial);

    int deleteRecordsForUser(int userId);

}
