package com.techelevator.dao;

import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcClaimedDaoTest extends BaseDaoTests {
    private JdbcClaimedDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcClaimedDao(jdbcTemplate);
    }

    @Test
    public void cannot_claim_already_claimed_instance() {

    }


}
