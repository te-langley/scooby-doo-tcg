package com.techelevator.dao;

import com.techelevator.model.Instance;

import java.util.List;

public interface InstanceDao {
    boolean createBatch(List<Instance> instance);

    List<String> getUsedSerials();
}
