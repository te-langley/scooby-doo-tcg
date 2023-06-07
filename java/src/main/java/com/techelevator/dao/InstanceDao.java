package com.techelevator.dao;

import com.techelevator.model.Instance;

import java.util.List;

public interface InstanceDao {
    public boolean createBatch(List<Instance> instance);
    public List<String> getUsedSerials();
}
