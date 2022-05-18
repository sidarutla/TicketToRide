package com.thesidproject;

import java.util.UUID;

public class Player {

    final String name;
    final String playerID;

    public Player(String name) {
        this.name = name;
        playerID = UUID.randomUUID().toString();
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return name;
    }
}