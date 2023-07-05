package com.techelevator.dao;

import com.techelevator.model.Instance;

import java.util.List;

public interface InstanceDao {

    /**
     * Adds the {@code Instance} to the database.
     *
     * @param instance
     * @return The number of rows added to the database.
     */
    int create(Instance instance);

    Instance read(String serial);

    List<Instance> readAll();

    boolean contains(String proposedSerial);

    boolean alreadyGeneratedForRun(int runCode);

    boolean unlock(String serial);

    boolean delete(String serial);

    boolean delete(int runCode);
}
