package com.techelevator.dao;

import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public abstract class AbstractDao<T> {

public abstract T read(int id);
public abstract List<T> readAll();
public abstract boolean exists(int id);
public abstract T mapRowToModel(SqlRowSet results);

}
