package com.thesidproject;

import java.util.UUID;

public class Ticket {

    final String source;
    final String destination;
    final int value;
    final String ticketID;

    public Ticket(String source, String destination, int value) {
        this.source = source;
        this.destination = destination;
        this.value = value;
        this.ticketID = UUID.randomUUID().toString();

    }

    public static Ticket buildTicket(String source, String destination, int value) {
        Ticket ticket = new Ticket(source, destination, value);
        return ticket;
    }

    public String toString() {
        String string = source + " to " + destination + " for " + value + " points";
        return string;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getValue() {
        return value;
    }

    public String getTicketID() {
        return ticketID;
    }
}
