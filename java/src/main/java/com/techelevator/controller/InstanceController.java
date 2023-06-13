package com.techelevator.controller;

import com.techelevator.dao.InstanceDao;
import com.techelevator.model.Instance;
import com.techelevator.model.ProductionRun;
import com.techelevator.util.BatchSerialGenerator;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instance")
@CrossOrigin
public class InstanceController {
    private final InstanceDao instanceDao;

    public InstanceController(InstanceDao instanceDao) {
        this.instanceDao = instanceDao;
    }

    public boolean contains(String serial) {
        // use dao to see if serial exists.
        return false;
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean post(@RequestBody Instance instance) {
        return instanceDao.create(instance);
    }
    // GETS
    // PUTS
    // POSTS
    // batch serial generator
}
