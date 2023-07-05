package com.techelevator.dao;

import com.techelevator.model.ProductionRun;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDate;
import java.util.List;

public class JdbcProductionRunDaoTests extends BaseDaoTests {
    private static final ProductionRun RUN_TO_CREATE = new ProductionRun() {{
        setProductCode(1);
        setProductionDate(LocalDate.of(1991, 10, 20));
        setVolume(42);
        setStatus("Pending");
        setNotes("Junk Run");
    }};
    private JdbcProductionRunDao prDao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        prDao = new JdbcProductionRunDao(jdbcTemplate);
    }

    @Test
    public void created_run_has_expected_values_when_retrieved() {
        ProductionRun dbRun = prDao.createProductionRun(RUN_TO_CREATE);
        Assert.assertEquals(dbRun.getRunCode(), 12);
        Assert.assertEquals(dbRun.getProductCode(), 1);
        Assert.assertEquals(dbRun.getProductionDate(), LocalDate.of(1991, 10, 20));
        Assert.assertEquals(dbRun.getVolume(), 42);
        Assert.assertEquals(dbRun.getStatus(), "Pending");
        Assert.assertEquals(dbRun.getNotes(), "Junk Run");
    }

    @Test
    public void getAll_returns_all_production_runs() {
        List<ProductionRun> prs = prDao.getAllProductionRuns();

        Assert.assertNotNull(prs);
        Assert.assertEquals(11, prs.size());
    }

    @Test
    public void get_returns_the_correct_run() {
        ProductionRun dbRun = prDao.getProductionRunById(1);
        Assert.assertEquals(dbRun.getRunCode(), 1);
        Assert.assertEquals(dbRun.getProductCode(), 1);
        Assert.assertEquals(dbRun.getProductionDate(), LocalDate.of(2023, 04, 20));
        Assert.assertEquals(dbRun.getVolume(), 100);
        Assert.assertEquals(dbRun.getStatus(), "Completed");
        Assert.assertEquals(dbRun.getNotes(), "");
    }
}
