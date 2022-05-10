package com.thesidproject.ttr.app;


import com.thesidproject.Board;
import com.thesidproject.Player;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Component
public class PlayerManager {

    private static Map<String, Player> players = new HashMap<>();

    public Player createPlayer(String playerName) {
        Player player = new Player(playerName);
        players.put(player.getPlayerID(), player);
        return player;
    }

    public Player getPlayer(String playerID) {
        return players.get(playerID);
    }
}
