package com.thesidproject;

public class Ticket {

    String source;
    String destination;
    int value;

    public Ticket(String source, String destination, int value) {
        this.source = source;
        this.destination = destination;
        this.value = value;
    }

    public static Ticket buildTicket(String source, String destination, int value) {
        Ticket ticket = new Ticket(source, destination, value);
        return ticket;
    }

    public String toString() {
        String string = source + " to " + destination + " for " + value + " points";
        return string;
    }
}
