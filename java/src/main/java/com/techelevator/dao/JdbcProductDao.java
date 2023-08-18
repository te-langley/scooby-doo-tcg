package com.techelevator.dao;

import com.techelevator.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcProductDao implements ProductDao {
    //==============================================================================
    // INSTANCE VARIABLES
    //==============================================================================
    private final String TABLE = "product";
    private final JdbcTemplate jdbcTemplate;
    private final GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();

    //==============================================================================
    // CONSTRUCTOR
    //==============================================================================
    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //==============================================================================
    // CLASS METHODS
    //==============================================================================
    @Override
    public Product createProduct(Product product) {
        String sql = "insert into " +
                TABLE +
                " (name, species, occupation, catchphrase, image)" +
                " values (?,?,?,?,?)";

        int rowsAdded = jdbcTemplate.update(conn -> {
            PreparedStatement preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getSpecies());
            preparedStatement.setString(3, product.getOccupation());
            preparedStatement.setString(4, product.getCatchphrase());
            preparedStatement.setString(5, product.getImage());

            return preparedStatement;
        }, generatedKeyHolder);

        Product createdProduct = null;
        if (rowsAdded > 0) {
            createdProduct = getProductById((Integer) generatedKeyHolder.getKeys().get("id"));
        }

        return createdProduct;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String sql = "select * from " + TABLE;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            products.add(mapRowToModel(results));
        }
        return products;
    }

    @Override
    public Product getProductById(int id) {
        String sql = "select * from " + TABLE + " where id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next()) {
            return mapRowToModel(results);
        } else {
            return null;
        }
    }

    @Override
    public Product updateProduct(Product product) {
        String sql = "update " +
                TABLE +
                " set name = ?, species = ?, occupation = ?, catchphrase = ?" +
                " where id = ? ";
        int rowsUpdated = jdbcTemplate.update(sql,
                product.getName(),
                product.getSpecies(),
                product.getOccupation(),
                product.getCatchphrase(),
                product.getProductCode());

        Product updatedProduct = null;
        if (rowsUpdated > 0) {
            updatedProduct = getProductById(product.getProductCode());
        }
        return updatedProduct;
    }

    //==============================================================================
    // UTILITY/HELPER METHODS
    //==============================================================================

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
