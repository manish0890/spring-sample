package com.manish0890.spring.sample.controller.players;

import com.manish0890.spring.sample.persistance.document.Player;
import com.manish0890.spring.sample.service.players.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.manish0890.spring.sample.constants.RequestMappingConstants.Players.PLAYERS;
import static com.manish0890.spring.sample.constants.RequestMappingConstants.Players.PLAYER_BY_ID;

@RestController
@RequestMapping(PLAYERS)
@Tag(name = "Players controller - Upload players from CVS, Get All Players, etc")
public class PlayersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PlayersController.class);

    private final PlayerService playerService;

    @Autowired
    public PlayersController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get All Players from CSV file")
    public List<Player> getAllPlayers() {
        LOGGER.info("Received request to get a list of Players");
        return playerService.getPlayersFromCsv();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Upload All Players from CSV to database")
    public void uploadAllPlayers() {
        LOGGER.info("Received request to upload all Players in database");
        playerService.uploadPlayers();
    }

    @GetMapping(PLAYER_BY_ID)
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get Player by PlayerID")
    public Player getPlayer(@PathVariable String playerID) {
        LOGGER.info("Returning list of Players");
        return playerService.getPlayer(playerID);
    }

}