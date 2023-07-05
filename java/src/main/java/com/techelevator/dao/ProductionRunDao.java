package com.techelevator.dao;

import com.techelevator.model.ProductionRun;

import java.util.List;

public interface ProductionRunDao {
    /**
     * Adds {@code run} to the database.
     *
     * @param run
     * @return The added run, including its generated id.
     */
    ProductionRun createProductionRun(ProductionRun run);

    /**
     * @param id
     * @return The production run with the given id.
     */
    ProductionRun getProductionRunById(int id);

    /**
     * Gets all runs in the database.
     *
     * @return All recorded production runs.
     */
    List<ProductionRun> getAllProductionRuns();

    /**
     * @param productCode The product id to retrieve runs for
     * @return All production runs for the given product code.
     */
    List<ProductionRun> getProductionRunsByProductCode(int productCode);

    /**
     * Overwrites all values of production run in the database.
     * @param run
     * @return The updated run retrieved from the database.
     */
    ProductionRun updateProductionRun(ProductionRun run);

    /**
     * Overwrites only the status of a production run in the database.
     * @param run
     * @return The updated run retrieved from the database.
     */
    ProductionRun updateProductionRunStatus(ProductionRun run);
}
