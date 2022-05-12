package com.thesidproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GamePlayer {

    final String playerID;
    final String name;
    final PlayerColor playerColor;

    int tracks = 45;
    int score = 0;
    List<Ticket> tickets = new ArrayList<>();
    List<Ticket> drawnTickets = new ArrayList<>();
    List<Card> cards = new ArrayList<>();
    List<List<String>> connectedCities = new ArrayList<>();

    public GamePlayer(String playerID, String playerName, PlayerColor inputColor) {
        this.playerID = playerID;
        this.name = playerName;
        this.playerColor = inputColor;
    }

    public void print() {
        System.out.println("Player " + name + ", here are your stats:");
        System.out.println("score:");
        System.out.println(score);
        System.out.println();
        System.out.println("number of tracks:");
        System.out.println(tracks);
        System.out.println();
        System.out.println("tickets:");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
        System.out.println();
        System.out.println("cards:");
        for (Card card : cards) {
            System.out.println(card);
        }
        System.out.println();
    }


    public void drawTickets(List<Ticket> ticketList) {
        for (int i = 0; i < 3; i++) {
            tickets.add(ticketList.get(0));
            ticketList.remove(0);
            System.out.println(tickets.get(i));
        }
    }

    public void addCards(List<Card> cardList) {
        for (int i = 0; i < 4; i++) {
            cards.add(cardList.get(0));
            cardList.remove(0);
        }
    }


    public String getPlayerID() {
        return playerID;
    }

    public String getPlayerName() {
        return name;
    }

    public PlayerColor getPlayerColor() {
        return playerColor;
    }

    public int getTracks() {
        return tracks;
    }

    public int getScore() {
        return score;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Ticket> getDrawnTickets() {
        return drawnTickets;
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<List<String>> getConnectedCities() {
        return connectedCities;
    }
}