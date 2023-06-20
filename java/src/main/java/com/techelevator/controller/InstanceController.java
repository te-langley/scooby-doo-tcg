package com.techelevator.controller;

import com.techelevator.dao.InstanceDao;
import com.techelevator.model.Instance;
import com.techelevator.model.ProductionRun;
import com.techelevator.util.SerialGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/instance")
@CrossOrigin
public class InstanceController {
    private final InstanceDao instanceDao;

    public InstanceController(InstanceDao instanceDao) {
        this.instanceDao = instanceDao;
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean post(@RequestBody ProductionRun run) {
        for (int i = 1; i <= run.getVolume(); i++) {
            Instance instance = new Instance();

            instance.setSerial(generateSerial());
            instance.setProductCode(run.getProductCode());
            instance.setProductionRun(run.getRunCode());
            instance.setSequence(i);
            instance.setClaimed(false);

            instanceDao.create(instance);
        }
        return false;
    }

    @RequestMapping(value = "/{serial}", method = RequestMethod.GET)
    public Instance read(@PathVariable String serial) {
        return instanceDao.read(serial);
    }

    @RequestMapping(method = RequestMethod.GET)
    public Instance readAll() {
        List<Instance> instances = new ArrayList<>();
        return instanceDao.readAll();
    }

    //    REVIEW: I don't think I like using the serial as a path variable here.
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public boolean unlock(@PathVariable String serial) {
        return instanceDao.unlock(serial);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable String id) {
        return instanceDao.delete(id);
    }

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

}
