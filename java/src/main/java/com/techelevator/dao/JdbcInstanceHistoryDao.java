package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcInstanceHistoryDao implements InstanceHistoryDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcInstanceHistoryDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
