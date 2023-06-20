package com.techelevator.dao;

import com.techelevator.model.Instance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcInstanceDao implements InstanceDao {
    private final String TABLE = "instance";
    private final JdbcTemplate jdbcTemplate;

    public JdbcInstanceDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(Instance instance) {
        String sql = "insert into " + TABLE + " (serial, product_code, production_run, sequence, claimed) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, instance.getSerial(), instance.getProductCode(), instance.getProductionRun(), instance.getSequence(), instance.isClaimed()) == 1;
    }

    @Override
    public Instance read(String serial) {
        String sql = "select (serial, product_code, production_run, sequence, claimed) from instance where serial = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, serial);
        if (results.next()) {
            return mapRowToModel(results);
        } else {
            return null;
        }
    }

    @Override
    public Instance readAll() {
        String sql = "";
        return null;
    }

    @Override
    public boolean contains(String serial) {
        String sql = "select count(*) from " + TABLE + " where serial = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{serial}, Integer.class);
        return count > 0;
    }

    @Override
    public boolean unlock(String serial) {
        String sql = "update " + TABLE + "set claimed='true' WHERE serial=?";
        return jdbcTemplate.update(sql, serial) == 1;
    }

    @Override
    public boolean delete(String serial) {
        String sql = "delete from " + TABLE + " where serial = ?";
        return jdbcTemplate.update(sql, serial) == 1;
    }

    Instance mapRowToModel(SqlRowSet results) {
        Instance instance = new Instance();

        instance.setSerial(results.getString("serial"));
        instance.setProductCode(results.getInt("product_code"));
        instance.setProductionRun(results.getInt("production_run"));
        instance.setSequence(results.getInt("sequence"));
        instance.setClaimed(results.getBoolean("claimed"));

        return instance;
    }
}
