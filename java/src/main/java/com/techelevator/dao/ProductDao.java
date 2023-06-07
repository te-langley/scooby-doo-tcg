package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao {
    //==========================================================================
    // CREATE Operations
    //==========================================================================
    boolean create(Product product);

    //==========================================================================
    // READ Operations
    //==========================================================================
    /**
     * @param id
     * @return product with given {@code id}
     */
    Product read(int productCode);

    /**
     * @return all products from the data source.
     */
    List<Product> readAll();

    //==========================================================================
    // UPDATE Operations
    //==========================================================================
    boolean update(int id, Product updated);
    //==========================================================================
    // DELETE Operations
    //==========================================================================
    boolean delete(int id);

}
