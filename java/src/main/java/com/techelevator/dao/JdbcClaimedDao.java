package com.techelevator.dao;

import com.techelevator.model.Claimed;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcClaimedDao implements ClaimedDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcClaimedDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int createClaimRecord(String serial, int userId) {
        String sql = "insert into claimed(serial, user_id) values (?, ?)";
        return jdbcTemplate.update(sql, serial, userId);
    }

    @Override
    public List<String> getSerialsForUser(int userId) {
        List<String> userSerials = new ArrayList<>();
        String sql = "SELECT serial FROM claimed where user_id=?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while (results.next()) {
            userSerials.add(results.getString("serial"));
        }
        return userSerials;
    }

    @Override
    public boolean isClaimed(String serial) {
        String sql = "SELECT EXISTS(SELECT 1 FROM claimed WHERE serial=?)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, serial);
        return results.getBoolean(0);
    }

    @Override
    public Claimed updateRecord(String serial, int userId) {
        Claimed updatedRecord = null;
        String sql = "UPDATE claimed SET user_id=? WHERE serial=?";
        int results = jdbcTemplate.update(sql, userId, serial);
        //TODO


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
