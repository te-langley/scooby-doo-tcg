package com.techelevator.dao;

import com.techelevator.model.Product;

import java.util.List;

public interface ProductDao {
    //==========================================================================
    // CREATE Operations
    //==========================================================================
    Product createProduct(Product product);

    //==========================================================================
    // READ Operations
    //==========================================================================

    /**
     * @param id
     * @return product with given {@code id}
     */
    Product getProductById(int productCode);

    /**
     * @return all products from the data source.
     */
    List<Product> getAllProducts();

    //==========================================================================
    // UPDATE Operations
    //==========================================================================
    Product updateProduct(Product updated);

    //==========================================================================
    // DELETE Operations
    //==========================================================================

}
