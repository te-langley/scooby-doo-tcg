package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scooby-cards")
@CrossOrigin
public class ProductController {
    private final ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    //==========================================================================
    // PUBLIC
    //==========================================================================

    /**
     * Returns all products.
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAll() {
        return productDao.getAllProducts();
    }

    /**
     * Return product for a given ID.
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getWithId(@PathVariable int id) {
        return productDao.getProductById(id);
    }

    //==========================================================================
    // INTERNAL
    //==========================================================================

    /**
     * Request to add a new product to the database.
     * @param product The desired product values.
     * @return The added product.
     */
    @RequestMapping(method = RequestMethod.POST)
    public Product post(@RequestBody Product product) {
        return productDao.createProduct(product);
    }

    /**
     * Request to update the entire product in the database.
     * @param product
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        return productDao.updateProduct(product);
    }

}
