package com.techelevator.dao;

import com.techelevator.model.ProductionRun;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcProductionRunDaoTests extends BaseDaoTests {

    private JdbcProductionRunDao prDao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        prDao = new JdbcProductionRunDao(jdbcTemplate);
    }

    @Test
    public void findAll_returns_all_production_runs() {
        List<ProductionRun> prs = prDao.readAll();

        Assert.assertNotNull(prs);
        Assert.assertEquals(9, prs.size());
    }
}
