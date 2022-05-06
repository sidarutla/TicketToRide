package com.thesidproject;

import junit.framework.TestCase;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class BoardBuilderTest extends TestCase {


    public void testCreateCards() {
        BoardBuilder boardBuilder = new BoardBuilder();
        List<Card> cards = boardBuilder.createCards();
        Assert.assertEquals("Validating number of cards", 110, cards.size());
        for (GameColor color : GameColor.values()) {
            String message = "Validating number of cards of color " + color;
            int expectedCount = color == GameColor.any ? 14 : 12;
            Assert.assertEquals(message, expectedCount, cards.stream().filter(c -> c.gameColor == color).collect(Collectors.toList()).size());
        }
    }
}