package com.thesidproject.ttr.app;

import com.thesidproject.GameColor;

public class PlayerData {

    private String playerId;
    private String playerName;
    private GameColor playerColor;

    public PlayerData(String playerId, String playerName, GameColor playerColor) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerColor = playerColor;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public GameColor getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(GameColor playerColor) {
        this.playerColor = playerColor;
    }
}
