package com.techelevator.controller;

import com.techelevator.dao.JdbcProductDao;
import com.techelevator.dao.ProductDao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class ProductControllerTest extends BaseControllerTests {

    private ProductDao dao;

    @Before
    public void setup() {
        dao = new JdbcProductDao(new JdbcTemplate(dataSource));
    }

    @Test
    public void getAllShouldReturnStatusOk() throws Exception {
        mvc.perform(get("/api/scooby-cards").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
