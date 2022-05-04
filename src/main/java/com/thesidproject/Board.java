package com.thesidproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    List<Player> playerList;

    Connection cn1 = Connection.buildConnection("Vancouver", "Seattle", true, 1, TrackColor.grey, TrackColor.grey);
    Connection cn2 = Connection.buildConnection("Vancouver", "Calgary", false, 3, TrackColor.grey, null);
    Connection cn3 = Connection.buildConnection("Seattle", "Portland", true, 1, TrackColor.grey, TrackColor.grey);
    Connection cn4 = Connection.buildConnection("Seattle", "Helena", false, 6, TrackColor.yellow, null);
    Connection cn5 = Connection.buildConnection("Seattle", "Calgary", false, 4, TrackColor.grey, null);
    Connection cn6 = Connection.buildConnection("Portland", "San Francisco", true, 5, TrackColor.green, TrackColor.pink);
    Connection cn7 = Connection.buildConnection("Portland", "Salt Lake City", false, 6, TrackColor.blue, null);
    Connection cn8 = Connection.buildConnection("San Francisco", "Los Angeles", true, 3, TrackColor.yellow, TrackColor.pink);
    Connection cn9 = Connection.buildConnection("San Francisco", "Salt Lake City", true, 5, TrackColor.orange, TrackColor.white);
    Connection cn10 = Connection.buildConnection("Los Angeles", "Las Vegas", false, 2, TrackColor.orange, null);
    Connection cn11 = Connection.buildConnection("Los Angeles", "Phoenix", false, 3, TrackColor.grey, null);
    Connection cn12 = Connection.buildConnection("Los Angeles", "El Paso", false, 6, TrackColor.black, null);
    Connection cn13 = Connection.buildConnection("Las Vegas", "Salt Lake City", false, 3, TrackColor.orange, null);
    Connection cn14 = Connection.buildConnection("El Paso", "Santa Fe", false, 2, TrackColor.grey, null);
    Connection cn15 = Connection.buildConnection("El Paso", "Oklahoma City", false, 5, TrackColor.yellow, null);
    Connection cn16 = Connection.buildConnection("El Paso", "Dallas", false, 4, TrackColor.red, null);
    Connection cn17 = Connection.buildConnection("El Paso", "Houston", false, 6, TrackColor.green, null);
    Connection cn18 = Connection.buildConnection("Calgary", "Winnipeg", false, 6, TrackColor.white, null);
    Connection cn19 = Connection.buildConnection("Calgary", "Helena", false, 4, TrackColor.grey, null);
    Connection cn20 = Connection.buildConnection("Helena", "Winnipeg", false, 4, TrackColor.blue, null);
    Connection cn21 = Connection.buildConnection("Helena", "Duluth", false, 6, TrackColor.orange, null);
    Connection cn22 = Connection.buildConnection("Helena", "Omaha", false, 5, TrackColor.red, null);
    Connection cn23 = Connection.buildConnection("Helena", "Denver", false, 4, TrackColor.green, null);
    Connection cn24 = Connection.buildConnection("Helena", "Salt Lake City", false, 3, TrackColor.pink, null);
    Connection cn25 = Connection.buildConnection("Salt Lake City", "Denver", true, 3, TrackColor.red, TrackColor.yellow);
    Connection cn26 = Connection.buildConnection("Phoenix", "Denver", false, 5, TrackColor.white, null);
    Connection cn27 = Connection.buildConnection("Phoenix", "Santa Fe", false, 3, TrackColor.grey, null);
    Connection cn28 = Connection.buildConnection("Phoenix", "El Paso", false, 3, TrackColor.grey, null);
    Connection cn29 = Connection.buildConnection("Winnipeg", "Saint St. Marie", false, 6, TrackColor.grey, null);
    Connection cn30 = Connection.buildConnection("Winnipeg", "Duluth", false, 4, TrackColor.black, null);
    Connection cn31 = Connection.buildConnection("Denver", "Santa Fe", false, 2, TrackColor.grey, null);
    Connection cn32 = Connection.buildConnection("Denver", "Oklahoma City", false, 4, TrackColor.red, null);
    Connection cn33 = Connection.buildConnection("Denver", "Kansas City", true, 4, TrackColor.black, TrackColor.orange);
    Connection cn34 = Connection.buildConnection("Denver", "Omaha", false, 4, TrackColor.pink, null);
    Connection cn35 = Connection.buildConnection("Santa Fe", "Oklahoma City", false, 3, TrackColor.blue, null);
    Connection cn36 = Connection.buildConnection("Duluth", " Saint St. Marie", false, 3, TrackColor.grey, null);
    Connection cn37 = Connection.buildConnection("Duluth", "Toronto", false, 6, TrackColor.pink, null);
    Connection cn38 = Connection.buildConnection("Duluth", "Chicago", false, 3, TrackColor.red, null);
    Connection cn39 = Connection.buildConnection("Duluth", "Omaha", true, 2, TrackColor.grey, TrackColor.grey);
    Connection cn40 = Connection.buildConnection("Omaha", "Chicago", false, 4, TrackColor.blue, null);
    Connection cn41 = Connection.buildConnection("Omaha", "Kansas City", true, 1, TrackColor.grey, TrackColor.grey);
    Connection cn42 = Connection.buildConnection("Kansas City", "Saint Louis", true, 2, TrackColor.blue, TrackColor.pink);
    Connection cn43 = Connection.buildConnection("Kansas City", "Oklahoma City", true, 2, TrackColor.grey, TrackColor.grey);
    Connection cn44 = Connection.buildConnection("Oklahoma City", "Little Rock", false, 2, TrackColor.grey, null);
    Connection cn45 = Connection.buildConnection("Oklahoma City", "Dallas", true, 2, TrackColor.grey, TrackColor.grey);
    Connection cn46 = Connection.buildConnection("Dallas", "Little Rock", false, 2, TrackColor.grey, null);
    Connection cn47 = Connection.buildConnection("Dallas", "Houston", true, 1, TrackColor.grey, TrackColor.grey);
    Connection cn48 = Connection.buildConnection("Houston", "New Orleans", false, 2, TrackColor.grey, TrackColor.grey);
    Connection cn49 = Connection.buildConnection("Saint St. Marie", "Montreal", false, 5, TrackColor.black, null);
    Connection cn50 = Connection.buildConnection("Saint St. Marie", "Toronto", false, 2, TrackColor.grey, null);
    Connection cn51 = Connection.buildConnection("Toronto", "Chicago", false, 4, TrackColor.white, null);
    Connection cn52 = Connection.buildConnection("Toronto", "Montreal", false, 3, TrackColor.grey, null);
    Connection cn53 = Connection.buildConnection("Toronto", "Pittsburgh", false, 2, TrackColor.grey, null);
    Connection cn54 = Connection.buildConnection("Saint Louis", "Chicago", true, 2, TrackColor.green, TrackColor.white);
    Connection cn55 = Connection.buildConnection("Chicago", "Pittsburgh", true, 3, TrackColor.orange, TrackColor.black);
    Connection cn56 = Connection.buildConnection("Saint Louis", "Little Rock", false, 2, TrackColor.grey, null);
    Connection cn57 = Connection.buildConnection("Saint Louis", "Nashville", false, 2, TrackColor.grey, null);
    Connection cn58 = Connection.buildConnection("Saint Louis", "Pittsburgh", false, 5, TrackColor.green, null);
    Connection cn59 = Connection.buildConnection("Little Rock", "New Orleans", false, 3, TrackColor.green, null);
    Connection cn60 = Connection.buildConnection("Little Rock", "Nashville", false, 3, TrackColor.white, null);
    Connection cn61 = Connection.buildConnection("New Orleans", "Atlanta", true, 4, TrackColor.yellow, TrackColor.orange);
    Connection cn62 = Connection.buildConnection("Nashville", "Pittsburgh", false, 4, TrackColor.yellow, null);
    Connection cn63 = Connection.buildConnection("Nashville", "Raleigh", false, 3, TrackColor.black, null);
    Connection cn64 = Connection.buildConnection("Nashville", "Atlanta", false, 1, TrackColor.grey, null);
    Connection cn65 = Connection.buildConnection("Pittsburgh", "New York", true, 2, TrackColor.white, TrackColor.green);
    Connection cn66 = Connection.buildConnection("Pittsburgh", "Washington", false, 2, TrackColor.grey, null);
    Connection cn67 = Connection.buildConnection("Pittsburgh", "Raleigh", false, 2, TrackColor.grey, null);
    Connection cn68 = Connection.buildConnection("Raleigh", "Atlanta", true, 2, TrackColor.grey, TrackColor.grey);
    Connection cn69 = Connection.buildConnection("Raleigh", "Washington", true, 2, TrackColor.grey, TrackColor.grey);
    Connection cn70 = Connection.buildConnection("Raleigh", "Charleston", false, 2, TrackColor.grey, null);
    Connection cn71 = Connection.buildConnection("Atlanta", "Charleston", false, 2, TrackColor.grey, null);
    Connection cn72 = Connection.buildConnection("Atlanta", "Miami", false, 5, TrackColor.blue, null);
    Connection cn73 = Connection.buildConnection("Miami", "New Orleans", false, 6, TrackColor.red, null);
    Connection cn74 = Connection.buildConnection("Miami", "Charleston", false, 4, TrackColor.pink, null);
    Connection cn75 = Connection.buildConnection("Washington", "New York", true, 2, TrackColor.orange, TrackColor.black);
    Connection cn76 = Connection.buildConnection("New York", "Montreal", false, 3, TrackColor.blue, null);
    Connection cn77 = Connection.buildConnection("New York", "Boston", true, 2, TrackColor.yellow, TrackColor.red);
    Connection cn78 = Connection.buildConnection("Boston", "Montreal", true, 2, TrackColor.grey, TrackColor.grey);

    Ticket t1 = Ticket.buildTicket("Boston", "Miami", 12);
    Ticket t2 = Ticket.buildTicket("Calgary", "Phoenix", 13);
    Ticket t3 = Ticket.buildTicket("Calgary", "Salt Lake City", 7);
    Ticket t4 = Ticket.buildTicket("Chicago", "New Orleans", 7);
    Ticket t5 = Ticket.buildTicket("Chicago", "Santa Fe", 9);
    Ticket t6 = Ticket.buildTicket("Dallas", "New York", 11);
    Ticket t7 = Ticket.buildTicket("Denver", "El Paso", 4);
    Ticket t8 = Ticket.buildTicket("Denver", "Pittsburgh", 11);
    Ticket t9 = Ticket.buildTicket("Duluth", "El Paso", 10);
    Ticket t10 = Ticket.buildTicket("Duluth", "Houston", 8);
    Ticket t11 = Ticket.buildTicket("Helena", "Los Angeles", 8);
    Ticket t12 = Ticket.buildTicket("Kansas City", "Houston", 5);
    Ticket t13 = Ticket.buildTicket("Los Angeles", "Chicago", 16);
    Ticket t14 = Ticket.buildTicket("Los Angeles", "Miami", 20);
    Ticket t15 = Ticket.buildTicket("Los Angeles", "New York", 21);
    Ticket t16 = Ticket.buildTicket("Montreal", "Atlanta", 9);
    Ticket t17 = Ticket.buildTicket("Montreal", "New Orleans", 13);
    Ticket t18 = Ticket.buildTicket("New York", "Atlanta", 6);
    Ticket t19 = Ticket.buildTicket("Portland", "Nashville", 17);
    Ticket t20 = Ticket.buildTicket("Portland", "Phoenix", 11);
    Ticket t21 = Ticket.buildTicket("San Francisco", "Atlanta", 17);
    Ticket t22 = Ticket.buildTicket("Saint St. Marie", "Nashville", 8);
    Ticket t23 = Ticket.buildTicket("Saint St. Marie", "Oklahoma City", 9);
    Ticket t24 = Ticket.buildTicket("Seattle", "Los Angeles", 9);
    Ticket t25 = Ticket.buildTicket("Seattle", "New York", 22);
    Ticket t26 = Ticket.buildTicket("Toronto", "Miami", 10);
    Ticket t27 = Ticket.buildTicket("Vancouver", "Montreal", 20);
    Ticket t28 = Ticket.buildTicket("Vancouver", "Santa Fe", 13);
    Ticket t29 = Ticket.buildTicket("Winnipeg", "Houston", 12);
    Ticket t30 = Ticket.buildTicket("Winnipeg", "Little Rock", 11);

    public List<Card> createCards() {

        List<Card> cardList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            Card c1 = new Card(CardColor.red);
            Card c2 = new Card(CardColor.orange);
            Card c3 = new Card(CardColor.yellow);
            Card c4 = new Card(CardColor.green);
            Card c5 = new Card(CardColor.blue);
            Card c6 = new Card(CardColor.pink);
            Card c7 = new Card(CardColor.white);
            Card c8 = new Card(CardColor.black);
            Collections.addAll(cardList, c1, c2, c3, c4, c5, c6, c7, c8);
        }

        for (int i = 0; i < 14; i++) {
            Card c9 = new Card(CardColor.locomotive);
            cardList.add(c9);
        }

        return cardList;
    }

    List<Connection> connectionList = new ArrayList<>(Arrays.asList(cn1, cn2, cn3, cn4, cn5, cn6, cn7, cn8, cn9, cn10, cn11, cn12, cn13, cn14, cn15, cn16, cn17, cn18, cn19, cn20, cn21, cn22, cn23, cn24, cn25, cn26, cn27, cn28, cn29, cn30, cn31, cn32, cn33, cn34, cn35, cn36, cn37, cn38, cn39, cn40, cn41, cn42, cn43, cn44, cn45, cn46, cn47, cn48, cn49, cn50, cn51, cn52, cn53, cn54, cn55, cn56, cn57, cn58, cn59, cn60, cn61, cn62, cn63, cn64, cn65, cn66, cn67, cn68, cn69, cn70, cn71, cn72, cn73, cn74, cn75, cn76, cn77, cn78));
    List<Ticket> ticketList = new ArrayList<>(Arrays.asList(t23, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30));
    List<Card> fiveOpenCards = new ArrayList<>();
    List<Card> cardList = createCards();

    public Board(List<Player> inputPlayers) {
        this.playerList = inputPlayers;
    }

    public void shuffleTickets() {
        Collections.shuffle(ticketList);
    }

    public void shuffleCards() {
        Collections.shuffle(cardList);
    }

    public void distributeTickets() {

        for (Player player : playerList) {
            player.drawTickets(ticketList);
            for (int j = 0; j < 23; j++) {
                System.out.println();
            }
        }
    }

    public void distributeCards() {

        for (Player player : playerList) {
            player.addCards(cardList);
        }
    }

    public void openFiveCards() {
        int locos = 0;
        boolean threeLocos = true;

        while (threeLocos) {

            fiveOpenCards = new ArrayList<>(cardList.subList(0, 5));
            cardList.removeAll(fiveOpenCards);

            for (int i = 0; i < 5; i++) {
                Card card = fiveOpenCards.get(i);
                if (card.cardColor == CardColor.locomotive) {
                    locos += 1;
                }
            }
            if (locos < 3) {
                threeLocos = false;
            } else {
                cardList.addAll(fiveOpenCards);
                shuffleCards();
            }
        }
    }

    public void playYourTurn() {
        boolean isGamePlaying = true;
        int i = 0;
        List<Integer> scores = new ArrayList<>();
        while (isGamePlaying) {
            if (playerList.get(i).tracks <= 2) {
                playerList.get(i).playTurn(this, ticketList, connectionList);
                System.out.println(playerList.get(i));
                for (Player player : playerList) {
                    for (int k = 0; k < player.tickets.size(); k++) {
                        player.score -= player.tickets.get(k).value;
                    }
                    System.out.println("Player " + player.name + "'s score: " + player.score);
                    scores.add(player.score);
                }
                int highestScore = Collections.max(scores);
                boolean winningPlayerFound = false;
                for (Player player : playerList) {
                    if (player.score == highestScore && !winningPlayerFound) {
                        System.out.println("Player " + player.name + " wins!");
                        winningPlayerFound = true;
                    }
                }
                isGamePlaying = false;
            } else {
                playerList.get(i).playTurn(this, ticketList, connectionList);
                if (i < playerList.size() - 1) {
                    i++;
                } else {
                    i = 0;
                }
            }
        }
    }

    public void checkOpenCards() {
        System.out.println("Open cards:");
        for (Card fiveOpenCard : fiveOpenCards) {
            System.out.println(fiveOpenCard);
        }
        System.out.println();
    }

    public Card getCard(TakeCard card) {

        int cardIndex = card.ordinal();

        if (cardIndex <= 4) {
            Card wantedCard = fiveOpenCards.get(cardIndex);
            fiveOpenCards.remove(cardIndex);
            fiveOpenCards.add(cardList.get(0));
            cardList.remove(0);
            return wantedCard;
        } else {
            Card wantedCard = cardList.get(0);
            cardList.remove(0);
            return wantedCard;
        }
    }

    public boolean isTakeCardValid(TakeCard takeCard, boolean isFirstTurn) {
        return isFirstTurn || takeCard.ordinal() >= 5 || !fiveOpenCards.get(takeCard.ordinal()).isLocomotive();
    }

    public void start() {
        shuffleTickets();
        shuffleCards();
        distributeTickets();
        distributeCards();
        openFiveCards();
        playYourTurn();
    }
}






