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

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<Product> getAll() {
        return productDao.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product getWithId(@PathVariable int id) {
        return productDao.read(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean post(@RequestBody Product product) {
        return productDao.create(product);
    }

}
