package com.techelevator.dao;

import com.techelevator.model.Instance;

public interface InstanceDao {

    boolean create(Instance instance);

    Instance read(String serial);

    Instance readAll();

    boolean contains(String proposedSerial);

    boolean unlock(String serial);

    boolean delete(String serial);
}
