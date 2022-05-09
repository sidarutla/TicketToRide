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

    private static Map<String, MockPlayer> players = new HashMap<>();

    public MockPlayer createPlayer(String playerName) {
        String playerId = UUID.randomUUID().toString();
        MockPlayer player = new MockPlayer(playerId, playerName);
        players.put(playerId, player);
        return player;
    }

    public MockPlayer getPlayer(String playerId) {
        return players.get(playerId);
    }
}
