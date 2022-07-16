package com.manish0890.spring.sample.persistance.service;

import com.manish0890.spring.sample.model.exceptions.NotFoundException;
import com.manish0890.spring.sample.persistance.document.Player;
import com.manish0890.spring.sample.persistance.repository.PlayerRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class PlayerESService {

    private final PlayerRepository repository;

    @Autowired
    public PlayerESService(PlayerRepository repository) {
        this.repository = repository;
    }

    /**
     * Finds player by it's playerID (Not by Elasticsearch document ID!!)
     *
     * @param playerID
     * @return
     */
    public Player findByPlayerID(String playerID) {
        Assert.isTrue(StringUtils.isNotBlank(playerID), "playerID cannot be blank ");

        Player player = repository.findByPlayerID(playerID);

        if (player != null) {
            return player;
        } else {
            throw new NotFoundException("Player with playerID: " + playerID + " does not exist");
        }
    }

    /**
     * Saves list of players in database by one request
     *
     */
    public void savePlayers(List<Player> players) {
        Assert.isTrue(CollectionUtils.isNotEmpty(players), "players list cannot be empty");
        repository.saveAll(players);
    }

    /**
     * Saves player in database
     *
     */
    public void savePlayer(Player player) {
        Assert.notNull(player, "player cannot be null");

        repository.save(player);
    }
}
