package com.techelevator.dao;

import com.techelevator.model.CharacterCard;

import java.util.List;

public interface CharacterCardDao {
    //==========================================================================
    // CREATE Operations
    //==========================================================================
    boolean create(CharacterCard card);

    //==========================================================================
    // READ Operations
    //==========================================================================
    /**
     * @param id
     * @return character card with given {@code id}
     */
    CharacterCard read(int id);

    /**
     * @return all character cards from the data source.
     */
    List<CharacterCard> readAll();

    /**
     * Checks
     * @param id
     * @return
     */
    boolean exists(int id);
    //==========================================================================
    // UPDATE Operations
    //==========================================================================
    boolean update(int id, CharacterCard updated);
    //==========================================================================
    // DELETE Operations
    //==========================================================================
    boolean delete(int id);

}
