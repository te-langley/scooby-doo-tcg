package com.techelevator.dao;

import com.techelevator.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcProductDaoTests extends BaseDaoTests {
    private JdbcProductDao ccDao;
    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        ccDao = new JdbcProductDao(jdbcTemplate);
    }

    @Test
    public void findAll_returns_all_character_cards() {
        List<Product> ccs = ccDao.readAll();

        Assert.assertNotNull(ccs);
        Assert.assertEquals(6, ccs.size());
    }
}
