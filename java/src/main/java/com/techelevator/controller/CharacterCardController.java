package com.techelevator.controller;

import com.techelevator.dao.CharacterCardDao;
import com.techelevator.model.CharacterCard;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/scooby-cards")
@CrossOrigin
public class CharacterCardController {
    private final CharacterCardDao dao;

    public CharacterCardController(CharacterCardDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<CharacterCard> getAll() {
        return dao.readAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public CharacterCard getWithId(@PathVariable int id) {
        if (dao.exists(id)) {
            return dao.read(id);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Card with id " + id + " not found");
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public boolean post(@RequestBody CharacterCard card) {
        return dao.create(card);
    }

}
