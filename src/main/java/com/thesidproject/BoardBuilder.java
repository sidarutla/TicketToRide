package com.thesidproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BoardBuilder {

    public List<Card> createCards() {

        List<Card> cardList = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            Card c1 = new Card(GameColor.red);
            Card c2 = new Card(GameColor.orange);
            Card c3 = new Card(GameColor.yellow);
            Card c4 = new Card(GameColor.green);
            Card c5 = new Card(GameColor.blue);
            Card c6 = new Card(GameColor.pink);
            Card c7 = new Card(GameColor.white);
            Card c8 = new Card(GameColor.black);
            Collections.addAll(cardList, c1, c2, c3, c4, c5, c6, c7, c8);
        }

        for (int i = 0; i < 14; i++) {
            Card c9 = new Card(GameColor.any);
            cardList.add(c9);
        }

        return cardList;
    }

    public List<Ticket> createTickets() {
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
        return new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30));
    }

    public List<Connection> createConnections() {
        Connection cn1 = Connection.buildConnection("Vancouver", "Seattle", true, 1, GameColor.any, GameColor.any);
        Connection cn2 = Connection.buildConnection("Vancouver", "Calgary", false, 3, GameColor.any, null);
        Connection cn3 = Connection.buildConnection("Seattle", "Portland", true, 1, GameColor.any, GameColor.any);
        Connection cn4 = Connection.buildConnection("Seattle", "Helena", false, 6, GameColor.yellow, null);
        Connection cn5 = Connection.buildConnection("Seattle", "Calgary", false, 4, GameColor.any, null);
        Connection cn6 = Connection.buildConnection("Portland", "San Francisco", true, 5, GameColor.green, GameColor.pink);
        Connection cn7 = Connection.buildConnection("Portland", "Salt Lake City", false, 6, GameColor.blue, null);
        Connection cn8 = Connection.buildConnection("San Francisco", "Los Angeles", true, 3, GameColor.yellow, GameColor.pink);
        Connection cn9 = Connection.buildConnection("San Francisco", "Salt Lake City", true, 5, GameColor.orange, GameColor.white);
        Connection cn10 = Connection.buildConnection("Los Angeles", "Las Vegas", false, 2, GameColor.any, null);
        Connection cn11 = Connection.buildConnection("Los Angeles", "Phoenix", false, 3, GameColor.any, null);
        Connection cn12 = Connection.buildConnection("Los Angeles", "El Paso", false, 6, GameColor.black, null);
        Connection cn13 = Connection.buildConnection("Las Vegas", "Salt Lake City", false, 3, GameColor.orange, null);
        Connection cn14 = Connection.buildConnection("El Paso", "Santa Fe", false, 2, GameColor.any, null);
        Connection cn15 = Connection.buildConnection("El Paso", "Oklahoma City", false, 5, GameColor.yellow, null);
        Connection cn16 = Connection.buildConnection("El Paso", "Dallas", false, 4, GameColor.red, null);
        Connection cn17 = Connection.buildConnection("El Paso", "Houston", false, 6, GameColor.green, null);
        Connection cn18 = Connection.buildConnection("Calgary", "Winnipeg", false, 6, GameColor.white, null);
        Connection cn19 = Connection.buildConnection("Calgary", "Helena", false, 4, GameColor.any, null);
        Connection cn20 = Connection.buildConnection("Helena", "Winnipeg", false, 4, GameColor.blue, null);
        Connection cn21 = Connection.buildConnection("Helena", "Duluth", false, 6, GameColor.orange, null);
        Connection cn22 = Connection.buildConnection("Helena", "Omaha", false, 5, GameColor.red, null);
        Connection cn23 = Connection.buildConnection("Helena", "Denver", false, 4, GameColor.green, null);
        Connection cn24 = Connection.buildConnection("Helena", "Salt Lake City", false, 3, GameColor.pink, null);
        Connection cn25 = Connection.buildConnection("Salt Lake City", "Denver", true, 3, GameColor.red, GameColor.yellow);
        Connection cn26 = Connection.buildConnection("Phoenix", "Denver", false, 5, GameColor.white, null);
        Connection cn27 = Connection.buildConnection("Phoenix", "Santa Fe", false, 3, GameColor.any, null);
        Connection cn28 = Connection.buildConnection("Phoenix", "El Paso", false, 3, GameColor.any, null);
        Connection cn29 = Connection.buildConnection("Winnipeg", "Saint St. Marie", false, 6, GameColor.any, null);
        Connection cn30 = Connection.buildConnection("Winnipeg", "Duluth", false, 4, GameColor.black, null);
        Connection cn31 = Connection.buildConnection("Denver", "Santa Fe", false, 2, GameColor.any, null);
        Connection cn32 = Connection.buildConnection("Denver", "Oklahoma City", false, 4, GameColor.red, null);
        Connection cn33 = Connection.buildConnection("Denver", "Kansas City", true, 4, GameColor.black, GameColor.orange);
        Connection cn34 = Connection.buildConnection("Denver", "Omaha", false, 4, GameColor.pink, null);
        Connection cn35 = Connection.buildConnection("Santa Fe", "Oklahoma City", false, 3, GameColor.blue, null);
        Connection cn36 = Connection.buildConnection("Duluth", "Saint St. Marie", false, 3, GameColor.any, null);
        Connection cn37 = Connection.buildConnection("Duluth", "Toronto", false, 6, GameColor.pink, null);
        Connection cn38 = Connection.buildConnection("Duluth", "Chicago", false, 3, GameColor.red, null);
        Connection cn39 = Connection.buildConnection("Duluth", "Omaha", true, 2, GameColor.any, GameColor.any);
        Connection cn40 = Connection.buildConnection("Omaha", "Chicago", false, 4, GameColor.blue, null);
        Connection cn41 = Connection.buildConnection("Omaha", "Kansas City", true, 1, GameColor.any, GameColor.any);
        Connection cn42 = Connection.buildConnection("Kansas City", "Saint Louis", true, 2, GameColor.blue, GameColor.pink);
        Connection cn43 = Connection.buildConnection("Kansas City", "Oklahoma City", true, 2, GameColor.any, GameColor.any);
        Connection cn44 = Connection.buildConnection("Oklahoma City", "Little Rock", false, 2, GameColor.any, null);
        Connection cn45 = Connection.buildConnection("Oklahoma City", "Dallas", true, 2, GameColor.any, GameColor.any);
        Connection cn46 = Connection.buildConnection("Dallas", "Little Rock", false, 2, GameColor.any, null);
        Connection cn47 = Connection.buildConnection("Dallas", "Houston", true, 1, GameColor.any, GameColor.any);
        Connection cn48 = Connection.buildConnection("Houston", "New Orleans", false, 2, GameColor.any, GameColor.any);
        Connection cn49 = Connection.buildConnection("Saint St. Marie", "Montreal", false, 5, GameColor.black, null);
        Connection cn50 = Connection.buildConnection("Saint St. Marie", "Toronto", false, 2, GameColor.any, null);
        Connection cn51 = Connection.buildConnection("Toronto", "Chicago", false, 4, GameColor.white, null);
        Connection cn52 = Connection.buildConnection("Toronto", "Montreal", false, 3, GameColor.any, null);
        Connection cn53 = Connection.buildConnection("Toronto", "Pittsburgh", false, 2, GameColor.any, null);
        Connection cn54 = Connection.buildConnection("Saint Louis", "Chicago", true, 2, GameColor.green, GameColor.white);
        Connection cn55 = Connection.buildConnection("Chicago", "Pittsburgh", true, 3, GameColor.orange, GameColor.black);
        Connection cn56 = Connection.buildConnection("Saint Louis", "Little Rock", false, 2, GameColor.any, null);
        Connection cn57 = Connection.buildConnection("Saint Louis", "Nashville", false, 2, GameColor.any, null);
        Connection cn58 = Connection.buildConnection("Saint Louis", "Pittsburgh", false, 5, GameColor.green, null);
        Connection cn59 = Connection.buildConnection("Little Rock", "New Orleans", false, 3, GameColor.green, null);
        Connection cn60 = Connection.buildConnection("Little Rock", "Nashville", false, 3, GameColor.white, null);
        Connection cn61 = Connection.buildConnection("New Orleans", "Atlanta", true, 4, GameColor.yellow, GameColor.orange);
        Connection cn62 = Connection.buildConnection("Nashville", "Pittsburgh", false, 4, GameColor.yellow, null);
        Connection cn63 = Connection.buildConnection("Nashville", "Raleigh", false, 3, GameColor.black, null);
        Connection cn64 = Connection.buildConnection("Nashville", "Atlanta", false, 1, GameColor.any, null);
        Connection cn65 = Connection.buildConnection("Pittsburgh", "New York", true, 2, GameColor.white, GameColor.green);
        Connection cn66 = Connection.buildConnection("Pittsburgh", "Washington", false, 2, GameColor.any, null);
        Connection cn67 = Connection.buildConnection("Pittsburgh", "Raleigh", false, 2, GameColor.any, null);
        Connection cn68 = Connection.buildConnection("Raleigh", "Atlanta", true, 2, GameColor.any, GameColor.any);
        Connection cn69 = Connection.buildConnection("Raleigh", "Washington", true, 2, GameColor.any, GameColor.any);
        Connection cn70 = Connection.buildConnection("Raleigh", "Charleston", false, 2, GameColor.any, null);
        Connection cn71 = Connection.buildConnection("Atlanta", "Charleston", false, 2, GameColor.any, null);
        Connection cn72 = Connection.buildConnection("Atlanta", "Miami", false, 5, GameColor.blue, null);
        Connection cn73 = Connection.buildConnection("Miami", "New Orleans", false, 6, GameColor.red, null);
        Connection cn74 = Connection.buildConnection("Miami", "Charleston", false, 4, GameColor.pink, null);
        Connection cn75 = Connection.buildConnection("Washington", "New York", true, 2, GameColor.orange, GameColor.black);
        Connection cn76 = Connection.buildConnection("New York", "Montreal", false, 3, GameColor.blue, null);
        Connection cn77 = Connection.buildConnection("New York", "Boston", true, 2, GameColor.yellow, GameColor.red);
        Connection cn78 = Connection.buildConnection("Boston", "Montreal", true, 2, GameColor.any, GameColor.any);
        return new ArrayList<>(Arrays.asList(cn1, cn2, cn3, cn4, cn5, cn6, cn7, cn8, cn9, cn10, cn11, cn12, cn13, cn14, cn15, cn16, cn17, cn18, cn19, cn20, cn21, cn22, cn23, cn24, cn25, cn26, cn27, cn28, cn29, cn30, cn31, cn32, cn33, cn34, cn35, cn36, cn37, cn38, cn39, cn40, cn41, cn42, cn43, cn44, cn45, cn46, cn47, cn48, cn49, cn50, cn51, cn52, cn53, cn54, cn55, cn56, cn57, cn58, cn59, cn60, cn61, cn62, cn63, cn64, cn65, cn66, cn67, cn68, cn69, cn70, cn71, cn72, cn73, cn74, cn75, cn76, cn77, cn78));
    }

    public GameColor getUnusedColor(List<GameColor> usedColors) {
        GameColor[] allColors = GameColor.values();
        for (GameColor allColor : allColors) {
            if(allColor == GameColor.any)
                continue;

            if(!usedColors.contains(allColor)) {
                return allColor;
            }
        }
        return null;
    }

}
