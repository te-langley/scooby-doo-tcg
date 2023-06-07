package com.techelevator.controller;

import com.techelevator.dao.ProductionRunDao;
import com.techelevator.model.ProductionRun;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production-runs")
@CrossOrigin
public class ProductionRunController {
    private final ProductionRunDao productionRunDao;

    public ProductionRunController(ProductionRunDao productionRunDao) {
        this.productionRunDao = productionRunDao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<ProductionRun> getAll() {
        return productionRunDao.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductionRun getWithId(@PathVariable int id) {
        return productionRunDao.read(id);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public List<ProductionRun> getForProduct(@PathVariable int id) {
        return productionRunDao.readForProduct(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean post(@RequestBody ProductionRun run) {
        return productionRunDao.create(run);
    }
}
