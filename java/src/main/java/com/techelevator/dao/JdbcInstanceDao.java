package com.techelevator.dao;

import com.techelevator.model.Instance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcInstanceDao implements InstanceDao {
    private final String TABLE = "instance";
    private final JdbcTemplate jdbcTemplate;

    public JdbcInstanceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Inserts a batch of instances into the table.
     *
     * @param instance
     * @return
     */
    public boolean createBatch(List<Instance> instances) {
        for (Instance instance : instances) {
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

    @Override
    public boolean create(Instance instance) {
        return false;
    }

    Instance mapRowToModel(SqlRowSet results) {
        return null;
    }
}
