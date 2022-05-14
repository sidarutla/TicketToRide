package com.thesidproject;

public class Card {

    GameColor gameColor;

    public Card(GameColor gameColor) {
        this.gameColor = gameColor;
    }

    public String toString() {
        return gameColor + "";
    }

    public boolean isLocomotive() {
        return gameColor == GameColor.any;
    }

    public GameColor getGameColor() {
        return gameColor;
    }

    public void setGameColor(GameColor gameColor) {
        this.gameColor = gameColor;
    }
}
