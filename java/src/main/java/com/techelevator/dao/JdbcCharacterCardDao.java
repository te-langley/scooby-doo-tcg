package com.techelevator.dao;

import com.techelevator.model.CharacterCard;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcCharacterCardDao implements CharacterCardDao {
    private final String TABLE = "character_card";
    private final JdbcTemplate jdbcTemplate;

    public JdbcCharacterCardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public boolean create(CharacterCard card) {
        String sql = "insert into " + TABLE + " (name, species, occupation, catchphrase, image) values (?,?,?,?,?)";
        return jdbcTemplate.update(sql, card.getName(), card.getSpecies(), card.getOccupation(), card.getCatchphrase(), card.getImage()) == 1;
    }

    @Override
    public CharacterCard read(int id) {
        String sql = "select * from " + TABLE + " where id = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
        if (results.next())
            return mapRowToModel(results);
        else return null;
    }

    @Override
    public List<CharacterCard> readAll() {
        List<CharacterCard> characterCards = new ArrayList<>();
        String sql = "select * from " + TABLE;
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            characterCards.add(mapRowToModel(results));
        }

        return characterCards;
    }

    @Override
    public boolean exists(int id) {
        String sql = "SELECT count(*) FROM "+TABLE+" WHERE id = ?";
        boolean exists;
        int count = jdbcTemplate.queryForObject(sql, new Object[] {id}, Integer.class);
        exists = count > 0;
        return exists;
    }

    @Override
    public boolean update(int id, CharacterCard updated) {
        String sql = "update " + TABLE + " set name = ?, species = ?, occupation = ?, catchphrase = ? where id = ? ";
        return jdbcTemplate.update(sql, updated.getName(), updated.getOccupation(), updated.getSpecies(), updated.getCatchphrase(), id) == 1;
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from " + TABLE + " where id = ? ";
        return jdbcTemplate.update(sql, id) == 1;
    }

    CharacterCard mapRowToModel(SqlRowSet results) {
        CharacterCard characterCard = new CharacterCard();
        characterCard.setId(results.getInt("id"));
        characterCard.setName(results.getString("name"));
        characterCard.setSpecies(results.getString("species"));
        characterCard.setOccupation(results.getString("occupation"));
        characterCard.setCatchphrase(results.getString("catchphrase"));
        characterCard.setImage(results.getString("image"));
        return characterCard;
    }
}
