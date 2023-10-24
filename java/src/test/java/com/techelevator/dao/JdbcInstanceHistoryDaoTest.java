package com.techelevator.dao;

import com.techelevator.model.InstanceHistory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;

public class JdbcInstanceHistoryDaoTest extends BaseDaoTests {
    private static final InstanceHistory NEW_CLAIM_RECORD = new InstanceHistory() {{
        setInstanceSerial("INST01");
        setUserId(1);
        setClaimed(true);
        setTimestamp(new Timestamp(2020,10,20,0,0,0,0));
    }};

    private JdbcInstanceHistoryDao dao;

    @Before
    public void setup() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        dao = new JdbcInstanceHistoryDao(jdbcTemplate);
    }

    @Test
    public void add_new_record_to_table() {
        notImplemented();
    }

    @Test
    public void retrieve_record_by_Id() {
        notImplemented();
    }

    @Test
    public void 
}