package com.thesidproject;


import java.util.UUID;

public class Connection {

    String connectionID;
    String source;
    String destination;
    Pathway pathway1;
    Pathway pathway2;

    public Connection(String source, String destination, Pathway pathway1, Pathway pathway2) {
        this.source = source;
        this.destination = destination;
        this.pathway1 = pathway1;
        this.pathway2 = pathway2;
        this.connectionID = UUID.randomUUID().toString();
    }

    public static Connection buildConnection(String source, String destination, boolean doubleTracks, int tracks, GameColor color1, GameColor color2) {
        Pathway pathway1 = new Pathway(tracks, color1, true, null);
        Pathway pathway2 = new Pathway(tracks, color2, true, null);

        return new Connection(source, destination, pathway1, doubleTracks ? pathway2 : null);
    }

    public String toString() {
        String string = source + ", " + destination + ", " + pathway1;
        if (pathway2 != null) {
            string += ", " + pathway2;
        }
        return string;
    }

    public String getConnectionID() {
        return connectionID;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public Pathway getPathway1() {
        return pathway1;
    }

    public Pathway getPathway2() {
        return pathway2;
    }
}


