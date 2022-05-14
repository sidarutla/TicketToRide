package com.thesidproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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