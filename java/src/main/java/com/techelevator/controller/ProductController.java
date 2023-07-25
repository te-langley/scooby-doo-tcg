package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/scooby-cards")
@CrossOrigin
public class ProductController {

    //==============================================================================
    // CLASS VARIABLE(S)
    //==============================================================================
    private final ProductDao productDao;

    //==============================================================================
    // CONSTRUCTOR(S)
    //==============================================================================

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    //==============================================================================
    // HANDLER METHODS
    //==============================================================================

    /**
     * Returns all products.
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAll() {
        return productDao.getAllProducts();
    }

    /**
     * <b>Return product for a given ID.</b>
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getWithId(@PathVariable int id) {
        return productDao.getProductById(id);
    }

    /**
     * <b>Add a new product to the database.</b>
     *
     * @param product The desired product values.
     * @return The added product.
     */
    @RequestMapping(method = RequestMethod.POST)
    public Product createProduct(@RequestBody Product product) {
        return productDao.createProduct(product);
    }

    /**
     * <b>Update the given product in the database.</b>
     *
     * @param product
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Product updateProduct(@RequestBody Product product) {
        return productDao.updateProduct(product);
    }

    // TODO Update product including the product id.

}
