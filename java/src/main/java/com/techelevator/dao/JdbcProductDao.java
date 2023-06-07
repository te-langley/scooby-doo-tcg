package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {
    private final String TABLE = "product";
    private final JdbcTemplate jdbcTemplate;

    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(Product product) {
        String sql = "insert into " + TABLE + " (name, species, occupation, catchphrase, image) values (?,?,?,?,?)";
        return jdbcTemplate.update(sql, product.getName(), product.getSpecies(), product.getOccupation(), product.getCatchphrase(), product.getImage()) == 1;
    }

    @Override
    public Product read(int id) {
        String sql = "select * from " + TABLE + " where id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next())
            return mapRowToModel(results);
        else return null;
    }

    @Override
    public List<Product> readAll() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from " + TABLE;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            products.add(mapRowToModel(results));
        }

        return products;
    }

    @Override
    public boolean update(int id, Product updated) {
        String sql = "update " + TABLE + " set name = ?, species = ?, occupation = ?, catchphrase = ? where id = ? ";
        return jdbcTemplate.update(sql, updated.getName(), updated.getOccupation(), updated.getSpecies(), updated.getCatchphrase(), id) == 1;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from " + TABLE + " where id = ? ";
        return jdbcTemplate.update(sql, id) == 1;
    }

    Product mapRowToModel(SqlRowSet results) {
        Product product = new Product();
        product.setProductCode(results.getInt("id"));
        product.setName(results.getString("name"));
        product.setSpecies(results.getString("species"));
        product.setOccupation(results.getString("occupation"));
        product.setCatchphrase(results.getString("catchphrase"));
        product.setImage(results.getString("image"));
        return product;
    }
}
