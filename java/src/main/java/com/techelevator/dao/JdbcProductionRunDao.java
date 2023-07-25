package com.techelevator.dao;

import com.techelevator.model.ProductionRun;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductionRunDao implements ProductionRunDao {
    private final String TABLE = "production_run";
    private final JdbcTemplate jdbcTemplate;
    private final GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

    public JdbcProductionRunDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public ProductionRun createProductionRun(ProductionRun run) {
        String sql = "insert into " +
                TABLE +
                " (product_code, production_date, quantity, status, notes)" +
                " values (?,?,?,?,?)";

        int rowsAdded = jdbcTemplate.update(conn -> {
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setInt(1, run.getProductCode());
            preparedStatement.setDate(2, Date.valueOf(run.getProductionDate()));
            preparedStatement.setInt(3, run.getVolume());
            preparedStatement.setString(4, run.getStatus());
            preparedStatement.setString(5, run.getNotes());

            return preparedStatement;
        }, generatedKeyHolder);

        ProductionRun createdRun = null;
        if (rowsAdded > 0) {
            createdRun = getProductionRunById((Integer) generatedKeyHolder.getKeys().get("id"));
        }
        return createdRun;
    }

    @Override
    public List<ProductionRun> getAllProductionRuns() {
        List<ProductionRun> productionRuns = new ArrayList<>();
        String sql = "select * from " + TABLE;

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            ProductionRun productionRun = mapRowToModel(results);
            productionRuns.add(productionRun);
        }

        return productionRuns;
    }

    @Override
    public ProductionRun getProductionRunById(int id) {
        String sql = "select * from " + TABLE + " where id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToModel(results);
        } else {
            return null;
        }
    }

    @Override
    public List<ProductionRun> getProductionRunsByProductCode(int productCode) {
        List<ProductionRun> productionRuns = new ArrayList<>();
        String sql = "select * from " + TABLE + " where product_code = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, productCode);
        while (results.next()) {
            productionRuns.add(mapRowToModel(results));
        }

        return productionRuns;
    }

    @Override
    public ProductionRun updateProductionRun(ProductionRun run) {
        String sql = "UPDATE " +
                TABLE +
                " set product_code = ?, production_date = ?, quantity = ?, status = ?, notes = ?" +
                " WHERE id=?";
        int rowsUpdated = jdbcTemplate.update(sql,
                run.getProductCode(),
                run.getProductionDate(),
                run.getVolume(),
                run.getStatus(),
                run.getNotes(),
                run.getRunCode());

        ProductionRun updatedRun = null;
        if (rowsUpdated > 0) {
            updatedRun = getProductionRunById(run.getRunCode());
        }
        return updatedRun;
    }

    @Override
    public ProductionRun updateProductionRunStatus(ProductionRun run) {
        String sql = "update " + TABLE + " set status = ? WHERE id = ?";
        int rowsUpdated = jdbcTemplate.update(sql, run.getStatus(), run.getRunCode());

        ProductionRun updatedRun = null;
        if (rowsUpdated > 0) {
            updatedRun = getProductionRunById(run.getRunCode());
        }

        return updatedRun;
    }

    @Override
    public ProductionRun deleteRun(int id) { // TODO
        return null;
    }

    ProductionRun mapRowToModel(SqlRowSet results) {
        ProductionRun productionRun = new ProductionRun();
        productionRun.setRunCode(results.getInt("id"));
        productionRun.setProductCode(results.getInt("product_code"));
        productionRun.setProductionDate(results.getDate("production_date").toLocalDate());
        productionRun.setVolume(results.getInt("quantity"));
        productionRun.setStatus(results.getString("status"));
        productionRun.setNotes(results.getString("notes"));
        return productionRun;
    }
}
