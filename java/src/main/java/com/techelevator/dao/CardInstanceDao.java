package com.techelevator.dao;

import com.techelevator.model.CardInstance;

import java.util.List;

public interface CardInstanceDao {
    public boolean createBatch(List<CardInstance> instance);
    public List<String> getUsedSerials();
}
