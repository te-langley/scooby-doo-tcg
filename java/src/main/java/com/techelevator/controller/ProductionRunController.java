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
        return productionRunDao.getAllProductionRuns();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ProductionRun getWithId(@PathVariable int id) {
        return productionRunDao.getProductionRunById(id);
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public List<ProductionRun> getForProduct(@PathVariable int id) {
        return productionRunDao.getProductionRunsByProductCode(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ProductionRun post(@RequestBody ProductionRun run) {
        return productionRunDao.createProductionRun(run);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ProductionRun updateStatus(@PathVariable int id, @RequestBody String status) {
        ProductionRun run = productionRunDao.getProductionRunById(id);
        run.setStatus(status);
        return productionRunDao.updateProductionRunStatus(run);
    }
}
