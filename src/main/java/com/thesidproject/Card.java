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

    public boolean isColorMatching(Pathway pathway) {
        if (pathway != null) {
            if (pathway.color == GameColor.any || gameColor == GameColor.any) {
                return true;
            } else if (pathway.color == gameColor) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
