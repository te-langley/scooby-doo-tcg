package com.techelevator.dao;

import com.techelevator.model.CardInstance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCardInstanceDao implements CardInstanceDao {
    private final String TABLE = "instance";
    private final JdbcTemplate jdbcTemplate;

    public JdbcCardInstanceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Inserts a batch of instances into the table.
     *
     * @param instance
     * @return
     */
    public boolean createBatch(List<CardInstance> instances) {
        for (CardInstance instance : instances) {
            //insert into instance (serial, product_code, production_run, sequence, claimed) value (?, ?, ?, ?)
        }
        return false;
    }

    /**
     * Returns every serial currently in the instance table.
     *
     * @return a complete list of used instance serials
     */
    @Override
    public List<String> getUsedSerials() {
        List<String> serials = new ArrayList<>();
        String sql = "select serial from " + TABLE;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            serials.add(results.getString("serial"));
        }
        return serials;
    }

    CardInstance mapRowToModel(SqlRowSet results) {
        return null;
    }
}
