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

    @Override
    public int createInstance(Instance instance) {
        String sql = "insert into " +
                TABLE +
                " (serial, product_code, production_run, sequence, claimed) values (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                instance.getSerial(),
                instance.getProductCode(),
                instance.getProductionRun(),
                instance.getSequence(),
                instance.isLocked());
    }

    @Override
    public List<Instance> getAllInstances() {
        List<Instance> instances = new ArrayList<>();
        String sql = "select * from instance";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            instances.add(mapRowToModel(results));
        }
        return instances;
    }

    @Override
    public Instance getInstanceBySerial(String serial) {
        String sql = "select serial, product_code, production_run, sequence, claimed from instance where serial = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, serial);
        if (results.next()) {
            return mapRowToModel(results);
        } else {
            return null;
        }
    }

    @Override
    public List<Instance> getInstancesForRun(int runCode) {
        List<Instance> instances = new ArrayList<>();
        String sql = "select * from instance where production_run = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            instances.add(mapRowToModel(results));
        }
        return instances;
    }

    @Override
    public boolean contains(String serial) {
        String sql = "select count(*) from " + TABLE + " where serial = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{serial}, Integer.class);
        return count > 0;
    }

    @Override
    public int instancesGeneratedForRun(int runCode) {
        String sql = "select count(*) from " + TABLE + " where production_run = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{runCode}, Integer.class);
        return count;
    }

    @Override
    public Instance unlock(String serial) {
        String sql = "update " + TABLE + " set claimed='true' WHERE serial = ?";
        int rowsUpdated = jdbcTemplate.update(sql, serial);

        Instance updatedInstance = null;
        if (rowsUpdated > 0) {
            updatedInstance = getInstanceBySerial(serial);
        }

        return updatedInstance;
    }

    @Override
    public int deleteInstance(String serial) {
        String sql = "delete from " + TABLE + " where serial = ?";
        return jdbcTemplate.update(sql, serial);
    }

    @Override
    public int deleteInstancesForRun(int runCode) {
        String sql = "DELETE FROM " + TABLE +" WHERE production_run = ?";
        return jdbcTemplate.update(sql, runCode);
    }

    Instance mapRowToModel(SqlRowSet results) {
        Instance instance = new Instance();

        instance.setSerial(results.getString("serial"));
        instance.setProductCode(results.getInt("product_code"));
        instance.setProductionRun(results.getInt("production_run"));
        instance.setSequence(results.getInt("sequence"));
        instance.setLocked(results.getBoolean("claimed"));

        return instance;
    }
}
