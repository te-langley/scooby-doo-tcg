package com.techelevator.controller;

import com.techelevator.dao.ClaimedDao;
import com.techelevator.dao.InstanceDao;
import com.techelevator.dao.InstanceEventDao;
import com.techelevator.model.Instance;
import com.techelevator.model.InstanceEvent;
import com.techelevator.util.InstanceEvents;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("claim")
public class ClaimController {

    //==============================================================================
    // CLASS VARIABLE(S)
    //==============================================================================

    private final InstanceDao instanceDao;
    private final ClaimedDao claimedDao;
    private final InstanceEventDao instanceEventDao;

    //==============================================================================
    // CONSTRUCTOR(S)
    //==============================================================================
    public ClaimController(InstanceDao instanceDao, ClaimedDao claimedDao, InstanceEventDao instanceEventDao) {
        this.instanceDao = instanceDao;
        this.claimedDao = claimedDao;
        this.instanceEventDao = instanceEventDao;
    }

    //==============================================================================
    // HANDLER METHODS
    //==============================================================================
    @PostMapping("/{serial}")
    public void claim(@PathVariable String serial, @RequestParam int userId) {
        Instance instance = instanceDao.getInstanceBySerial(serial);
        if (instance.isLocked()) {
            // 1. Unlock the instance.
            instance = instanceDao.unlock(serial);
            // 2. Add a record to the claimed table.
            int claimedRec = claimedDao.createClaimRecord(serial, userId);
            // 3. Add a record to the instance event table.

            InstanceEvent unlockEvent = new InstanceEvent();
            unlockEvent.setSerial(serial);
            unlockEvent.setUserId(userId);
            unlockEvent.setEvent(InstanceEvents.UNLOCK);
            unlockEvent.setDate(LocalDate.now());

            InstanceEvent createdEvent = instanceEventDao.createRecord(unlockEvent);

        } else {
            System.out.println("Re-claim not yet implemented.");
        }
    }


}
