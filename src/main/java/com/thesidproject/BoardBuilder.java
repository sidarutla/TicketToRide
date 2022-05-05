package com.thesidproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BoardBuilder {

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
}
