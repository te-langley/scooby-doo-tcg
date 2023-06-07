package com.techelevator.controller;

import com.techelevator.dao.ProductionRunDao;
import com.techelevator.model.ProductionRun;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/production-runs")
@CrossOrigin
public class ProductionRunController {
    private ProductionRunDao dao;

    public ProductionRunController(ProductionRunDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ProductionRun> getAll() {
        return dao.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductionRun getWithId(@PathVariable int id) {
        ProductionRun result = dao.read(id);
        if (result == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Production run with id " + id + " not found");
        } else {
            return result;
        }
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public List<ProductionRun> getForProduct(@PathVariable int id) {
        if (dao.existsForProduct(id)) {
            return dao.readForProduct(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Production run(s) for product with id " + id + " not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean post(@RequestBody ProductionRun run) {
        return dao.create(run);
    }
}
