package com.thesidproject;

public class Pathway {

    int tracks;

    GameColor color;

    boolean open;

    Player player;

    public Pathway(int tracks, GameColor color, boolean open, Player player) {
        this.tracks = tracks;
        this.color = color;
        this.open = open;
        this.player = player;
    }

    public String toString() {
        String string = tracks + ", " + color + ", ";
        if (open) {
            string += "open";
        } else {
            string += "closed";
        }
        return string;
    }
}
