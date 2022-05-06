package com.thesidproject;

import java.util.ArrayList;
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
}
