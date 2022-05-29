package com.thesidproject;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class GamePlayer {

    final String playerID;
    final String name;
    final PlayerColor playerColor;

    int tracks = 45;
    int score = 0;
    int scoreFromTracks;
    int scoreFromFinishedTickets;
    int scoreFromUnfinishedTickets;
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

    public boolean hasCommonCity(List<String> cityList1, List<String> cityList2) {
        for (String city1 : cityList1) {
            for (String city2 : cityList2) {
                if (city1.equals(city2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void compileConnectedCities(Connection connection) {

        List<String> newCities = new ArrayList<>();
        newCities.add(connection.source);
        newCities.add(connection.destination);
        connectedCities.add(newCities);

        for (int i = 0; i < connectedCities.size(); i++) {
            for (int j = i + 1; j < connectedCities.size(); j++) {
                if (hasCommonCity(connectedCities.get(i), connectedCities.get(j))) {
                    connectedCities.get(i).addAll(connectedCities.get(j));
                    connectedCities.get(j).clear();
                    i = -1;
                    break;
                }
            }
        }
        List<List<String>> newConnectedCities = new ArrayList<>();
        for (List<String> cityList : connectedCities) {
            if (cityList.size() != 0) {
                newConnectedCities.add(cityList);
            }
        }
        connectedCities = newConnectedCities;


        for (List<String> cityList : connectedCities) {
            for (int i = 0; i < cityList.size(); i++) {
                for (int j = i + 1; j < cityList.size(); j++) {
                    if (cityList.get(i).equals(cityList.get(j))) {
                        cityList.remove(j);
                        i = -1;
                    }
                }
            }
        }
    }

    public void scoreTickets() {
        for (Ticket ticket : tickets) {
            boolean isTicketFinished = false;
            for (List<String> cityList : connectedCities) {
                if (checkFinishedTicket(ticket.source, ticket.destination, cityList)) {
                    isTicketFinished = true;
                    break;
                }
            }
            if (isTicketFinished) {
                score += ticket.value;
                scoreFromFinishedTickets += ticket.value;
            } else {
                score -= ticket.value;
                scoreFromUnfinishedTickets -= ticket.value;
            }
        }
    }

    public boolean checkFinishedTicket(String source, String destination, List<String> cityList) {
        boolean sourceFound = false;
        boolean destinationFound = false;
        for (String city : cityList) {
            if (source.equals(city)) {
                sourceFound = true;
            }
            if (destination.equals(city)) {
                destinationFound = true;
            }
            if (sourceFound && destinationFound) {
                break;
            }
        }
        return sourceFound && destinationFound;
    }

    public List<String> findConnectedCities(List<Connection> connectionList, String city) {
        List <String> nextCities = new ArrayList<>();
        for (Connection connection : connectionList) {
            if (connection.source.equals(city)) {
                nextCities.add(connection.destination);
            }
            if (connection.destination.equals(city)) {
                nextCities.add(connection.destination);
            }
        }
        return nextCities;
    }

    public int getLongestRoute(List<Connection> connectionList) {
        List<String> checkedCities;
        int maxLength = 0;
        for (List<String> cityList: connectedCities) {
            for (String city : cityList) {

                for (String possibleNextCity : cityList) {
                    for (String nextCity : findConnectedCities(connectionList, city)) {
                        if (possibleNextCity.equals(nextCity)) {

                        }
                    }
                }
            }
        }
        return maxLength;
    }
}