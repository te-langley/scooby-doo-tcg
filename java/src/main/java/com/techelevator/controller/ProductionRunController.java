package com.techelevator.controller;

import com.techelevator.dao.ProductionRunDao;
import com.techelevator.model.ProductionRun;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production-runs")
@CrossOrigin
public class ProductionRunController {

    //==============================================================================
    // CLASS VARIABLE(S)
    //==============================================================================

    private final ProductionRunDao productionRunDao;

    //==============================================================================
    // CONSTRUCTOR(S)
    //==============================================================================

    public ProductionRunController(ProductionRunDao productionRunDao) {
        this.productionRunDao = productionRunDao;
    }

    //==========================================================================
    // HANDLER METHODS
    //==========================================================================

    @GetMapping()
    public List<ProductionRun> getAll() {
        return productionRunDao.getAllProductionRuns();
    }

    @GetMapping("/{id}")
    public ProductionRun getWithId(@PathVariable int id) {
        return productionRunDao.getProductionRunById(id);
    }

    @GetMapping("/product/{id}")
    public List<ProductionRun> getForProduct(@PathVariable int id) {
        return productionRunDao.getProductionRunsByProductCode(id);
    }

    @PostMapping
    public ProductionRun createRun(@RequestBody ProductionRun run) {
        return productionRunDao.createProductionRun(run);
    }

    @PutMapping
    public ProductionRun updateRun(@RequestBody ProductionRun run) {
        return productionRunDao.updateProductionRun(run);
    }

    @DeleteMapping
    public ProductionRun deleteRun(@RequestParam int id) {
        return productionRunDao.deleteRun(id);
    }
}
