package com.techelevator.dao;

import com.techelevator.model.ProductionRun;

import java.util.Date;
import java.util.List;

public interface ProductionRunDao {
    List<ProductionRun> readAll();
    ProductionRun read(int productionRunId);
    List<ProductionRun> readForProduct(int characterCardId);

    boolean exists(int id);

    boolean create(int productCode, Date productionDate, int quantity, String status, String notes);

    boolean create(ProductionRun run);
}
