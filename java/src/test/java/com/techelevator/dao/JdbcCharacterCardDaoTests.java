package com.techelevator.dao;

import com.techelevator.model.CharacterCard;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcCharacterCardDaoTests extends BaseDaoTests {
    private JdbcCharacterCardDao ccDao;
    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        ccDao = new JdbcCharacterCardDao(jdbcTemplate);
    }

    @Test
    public void findAll_returns_all_character_cards() {
        List<CharacterCard> ccs = ccDao.readAll();

        Assert.assertNotNull(ccs);
        Assert.assertEquals(6, ccs.size());
    }
}
