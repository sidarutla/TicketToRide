package com.thesidproject;

import java.util.UUID;

public class Pathway {

    String pathwayID;
    int tracks;

    GameColor color;

    GamePlayer gamePlayer;

    public Pathway(int tracks, GameColor color, GamePlayer gamePlayer) {
        this.tracks = tracks;
        this.color = color;
        this.gamePlayer = gamePlayer;
        this.pathwayID = UUID.randomUUID().toString();
    }


    public int getTracks() {
        return tracks;
    }

    public GameColor getColor() {
        return color;
    }

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public String getPathwayID() {
        return pathwayID;
    }
}
