package com.techelevator.dao;

import com.techelevator.model.ProductionRun;

import java.util.Date;
import java.util.List;

public interface ProductionRunDao {
    List<ProductionRun> readAll();
    ProductionRun read(int productionRunId);
    List<ProductionRun> readForProduct(int productCode);

    boolean exists(int id);

    boolean existsForProduct(int id);

    boolean create(ProductionRun run);
}
