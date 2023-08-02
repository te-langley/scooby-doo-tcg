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
    int createInstance(Instance instance);

    Instance getInstanceBySerial(String serial);

    List<Instance> getAllInstances();

    List<Instance> getInstancesForRun(int runCode);

    boolean contains(String proposedSerial);

    int instancesGeneratedForRun(int runCode);

    Instance unlock(String serial);

    int deleteInstance(String serial);

    int deleteInstancesForRun(int runCode);
}
