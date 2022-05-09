package com.thesidproject.ttr.app;

public class PlayerData {

    private String playerId;
    private String playerName;
    private String playerColor;

    public PlayerData(String playerId, String playerName, String playerColor) {
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

    public String getPlayerColor() {
        return playerColor;
    }

    public void setPlayerColor(String playerColor) {
        this.playerColor = playerColor;
    }
}
