package com.techelevator.controller;

import com.techelevator.dao.InstanceDao;
import com.techelevator.model.Instance;
import com.techelevator.model.ProductionRun;
import com.techelevator.util.SerialGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/instance")
@CrossOrigin
public class InstanceController {

    //==============================================================================
    // CLASS VARIABLE(S)
    //==============================================================================

    private final InstanceDao instanceDao;

    //==============================================================================
    // CONSTRUCTOR(S)
    //==============================================================================

    public InstanceController(InstanceDao instanceDao) {
        this.instanceDao = instanceDao;
    }

    //==============================================================================
    // HANDLER METHODS
    //==============================================================================

    /**
     * <b>Adds instance(s) to the database.</b>
     * <p>
     * Uses production run information to create and add a batch of instances to the database.  Unused serial numbers are generated on the fly.
     *
     * @param run
     * @return List of created instances.
     */
    @RequestMapping(method = RequestMethod.POST)
    public List<Instance> createFromRun(@RequestBody ProductionRun run) {
        List<Instance> createdInstances = null;
        if (shouldCreateInstances(run)) {
            createdInstances = new ArrayList<>();
            for (int i = 1; i <= run.getVolume(); i++) {
                Instance instance = new Instance();

                instance.setSerial(generateSerial());
                instance.setProductCode(run.getProductCode());
                instance.setProductionRun(run.getRunCode());
                instance.setSequence(i);
                instance.setLocked(false);

                int numCreated = instanceDao.createInstance(instance);

                Instance createdInstance = null;
                if (numCreated > 0) {
                    createdInstance = instanceDao.getInstanceBySerial(instance.getSerial());
                    createdInstances.add(createdInstance);
                }
            }
        }
        return createdInstances;
    }

    /**
     * <b>Returns the instance for the given serial.</b>
     *
     * @param serial
     * @return
     */
    @GetMapping()
    public Instance read(@RequestParam String serial) {
        Instance instance = instanceDao.getInstanceBySerial(serial.toUpperCase());
        if (instance != null) {
            return instance;
        } else {
            throw new InstanceNotFoundException();
        }
    }

    /**
     * <b>Returns all instances.</b>
     *
     * @return List of all instances.
     */
    @GetMapping("all")
    public List<Instance> readAll() {
        return instanceDao.getAllInstances();
    }

    /**
     * <b>Flips the claimed flag on the instance to true.</b>
     * TODO: Currently no way of "locking" the serial. Not sure if that's needed yet...
     *
     * @param serial
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Instance unlock(@PathVariable String serial) {
        return instanceDao.unlock(serial.toUpperCase());
    }

    /**
     * <b>Deletes the instance.</b>
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public int delete(@PathVariable String id) {
        return instanceDao.deleteInstance(id);
    }

    /**
     * <b>Deletes all instance(s) for a production run.</b>
     *
     * @param run
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public int delete(@RequestBody ProductionRun run) {
        return instanceDao.deleteInstancesForRun(run.getRunCode());
    }

    //==============================================================================
    // PRIVATE METHODS
    //==============================================================================

    private String generateSerial() {
        SerialGenerator sg = new SerialGenerator();
        String proposedSerial = "";

        while (!serialIsValid(proposedSerial)) {
            proposedSerial = SerialGenerator.generateSerial();
        }

        return proposedSerial;
    }

    private boolean serialIsValid(String proposedSerial) {
        if (proposedSerial.isBlank()) {
            return false;
        } else if (instanceDao.contains(proposedSerial)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean shouldCreateInstances(ProductionRun run) {
        if (!run.getStatus().equals("In Progress")) {
            return false;
        }

        if (instanceDao.instancesGeneratedForRun(run.getRunCode()) > 0) {
            return false;
        }

        return true;
    }

    //==============================================================================
    // PRIVATE EXCEPTIONS
    //==============================================================================

    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "No instance found for this serial.")
    private class InstanceNotFoundException extends RuntimeException {
    }
}
