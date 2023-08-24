package com.techelevator.controller;

import com.techelevator.dao.ProductDao;
import com.techelevator.model.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    protected MockMvc mvc;

    @MockBean
    ProductDao dao;

    @Test
    public void getAllShouldReturnStatusOk() throws Exception {
        mvc.perform(get("/api/scooby-cards").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void getbyIdWorks() throws Exception {
        when(dao.getProductById(1)).thenReturn(new Product() {{
            setName("Scooby Doo (Glitter)");
            setSpecies("Shiny Great Dane");
            setOccupation("Sparkly Mystery Solver");
            setCatchphrase("ScOoBy-DoObY-dOo!");
        }});

        mvc.perform(get("/api/scooby-cards/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(
                jsonPath("$.species").value("Shiny Great Dane"));
    }

}
