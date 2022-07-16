package com.manish0890.spring.sample.service.players;

import com.manish0890.spring.sample.persistance.document.Player;
import com.manish0890.spring.sample.persistance.service.PlayerESService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.manish0890.spring.sample.utils.CsvUtility.getRowsFromCsvFile;

@Service
public class PlayerService {

    @Value("${csv.file}")
    private String csvFile;

    private final PlayerESService playerESService;

    @Autowired
    public PlayerService(PlayerESService playerESService) {
        this.playerESService = playerESService;
    }

    /**
     * Read all players from a CSV file
     *
     * @return {@link List} of {@link Player}
     */
    public List<Player> getPlayersFromCsv() {

        List<String[]> rows = getRowsFromCsvFile(csvFile);

        List<Player> players = new ArrayList<>();

        for (int i = 1; i < rows.size(); i++) {

            Player player = getPlayerFromRow(rows.get(i));

            players.add(player);
        }

        return players;
    }

    /**
     * Read all players from a CSV file and upload in database
     */
    public void uploadPlayers() {
        playerESService.savePlayers(getPlayersFromCsv());
    }

    /**
     * Find a player using it's playerID
     * Finds record in database
     *
     * @param playerID playerID
     * @return {@link Player}
     */
    public Player getPlayer(String playerID) {
        return playerESService.findByPlayerID(playerID);
    }

    private Player getPlayerFromRow(String[] row) {
        Player player = new Player();
        player.setPlayerID(row[0]);

        if (StringUtils.isNotBlank(row[1])) {
            player.setBirthYear(Integer.parseInt(row[1]));
        }

        if (StringUtils.isNotBlank(row[2])) {
            player.setBirthMonth(Integer.parseInt(row[2]));
        }

        player.setBirthDay(row[3]);
        player.setBirthCountry(row[4]);
        player.setBirthState(row[5]);
        player.setBirthCity(row[6]);

        if (StringUtils.isNotBlank(row[7])) {
            player.setDeathYear(Integer.parseInt(row[7]));
        }

        if (StringUtils.isNotBlank(row[8])) {
            player.setDeathMonth(Integer.parseInt(row[8]));
        }

        if (StringUtils.isNotBlank(row[9])) {
            player.setDeathDay(Integer.parseInt(row[9]));
        }

        player.setDeathCountry(row[10]);
        player.setDeathState(row[11]);
        player.setDeathCity(row[12]);
        player.setNameFirst(row[13]);
        player.setNameLast(row[14]);
        player.setNameGiven(row[15]);

        if (StringUtils.isNotBlank(row[16])) {
            player.setWeight(Integer.parseInt(row[16]));
        }

        if (StringUtils.isNotBlank(row[17])) {
            player.setHeight(Integer.parseInt(row[17]));
        }

        player.setBats(row[18]);
        player.setThrowss(row[19]);
        player.setDebut(row[20]);
        player.setFinalGame(row[21]);
        player.setRetroID(row[22]);
        player.setBbrefID(row[23]);

        return player;
    }
}
