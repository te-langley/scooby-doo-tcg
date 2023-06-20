package com.techelevator.dao;

import com.techelevator.model.ProductionRun;

import java.util.List;

public interface ProductionRunDao {
    ProductionRun read(int productionRunId);

    List<ProductionRun> readAll();

    List<ProductionRun> readForProduct(int productCode);

    boolean create(ProductionRun run);

    boolean update(ProductionRun run);
}
