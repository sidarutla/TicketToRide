package com.thesidproject;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class BoardTest extends TestCase {

    Player sid = new Player("Sid");

    public void testBoardCreation() {
        Board b = new Board(sid, "Test");
        assertEquals("Number of players", 1, b.gamePlayerList.size());
        assertEquals("Check owning player", sid.playerID, b.owningPlayerID);
        assertEquals("Check game state", GameState.initializing, b.gameState);
    }

    public void testAddPlayer() {
        Board b = new Board(sid, "Test");
        Player bob = new Player("Bob");
        b.addPlayer(bob);
        assertEquals("Number of players,", 2, b.gamePlayerList.size());
        assertEquals("Check owning player", sid.playerID, b.owningPlayerID);
    }

    public void testStartGame() {
        Board b = new Board(sid, "Test");
        b.startGame(sid.playerID);
        assertEquals("Starting without enough players,", GameState.initializing, b.gameState);
        Player bob = new Player("Bob");

        b.addPlayer(bob);
        b.startGame(bob.playerID);
        assertEquals("Not started by owner,", GameState.initializing, b.gameState);

        b.gameState = GameState.finished;
        b.startGame(sid.playerID);
        assertEquals("Game already started cannot be started,", GameState.finished, b.gameState);

        b.gameState = GameState.initializing;
        b.startGame(sid.playerID);
        assertEquals("Valid start scenario", GameState.started, b.gameState);
    }

    public void testPickPlayType() {
        Board b = new Board(sid, "Test");
        b.startGame(sid.playerID);

        assertFalse("Not drawing tickets first round,", b.pickPlayType(sid.playerID, PlayType.drawCards));
        assertFalse("Not drawing tickets first round,", b.pickPlayType(sid.playerID, PlayType.buildTracks));

        b.isTurnInProgress = true;
        assertFalse("Turn is in progress", b.pickPlayType(sid.playerID, PlayType.buildTracks));
        b.isTurnInProgress = false;

        b.gameState = GameState.initializing;
        assertFalse("Game is not started", b.pickPlayType(sid.playerID, PlayType.drawTickets));
        b.gameState = GameState.finished;
        assertFalse("Game is not started", b.pickPlayType(sid.playerID, PlayType.drawTickets));
        b.gameState = GameState.started;

        Player bob = new Player("Bob");
        b.addPlayer(bob);
        assertFalse("Wrong player", b.pickPlayType(bob.playerID, PlayType.drawTickets));
    }

    public void testGetUnusedColor() {
        Board b = new Board(sid, "Test");
        Player bob = new Player("bob");
        b.addPlayer(bob);
        assertNotNull(b.getPlayerFromID(bob.playerID).playerColor);
    }

    public void testTickets() {
        Board b = new Board(sid, "Test");
        Player bob = new Player("bob");
        b.addPlayer(bob);

        b.startGame(sid.playerID);
        b.pickPlayType(sid.playerID, PlayType.drawTickets);
        b.drawTickets(sid.playerID);

        Ticket returnedTicket = b.getPlayerFromID(sid.playerID).drawnTickets.get(0);
        List<String> returnedticketIDList = new ArrayList<>();
        returnedticketIDList.add(returnedTicket.ticketID);
        b.returnTickets(sid.playerID, returnedticketIDList);

        boolean isTicketReturned = false;
        for (Ticket ticket : b.ticketList) {
            if (returnedTicket == ticket) {
                isTicketReturned = true;
                break;
            }
        }
        assertTrue(isTicketReturned);
        assertEquals(b.currentPlayerID, bob.playerID);
        b.pickPlayType(bob.playerID, PlayType.drawTickets);
        b.drawTickets(bob.playerID);
        List<String> returnedticketIDList2 = new ArrayList<>();
        b.returnTickets(bob.playerID, returnedticketIDList2);
        assertEquals(b.currentPlayerID, sid.playerID);
    }

    public void testConnectedCitiesAndTickets() {
        GamePlayer sid = new GamePlayer("123", "Sid", PlayerColor.green);

        Connection cn1 = Connection.buildConnection("Vancouver", "Seattle", true, 1, GameColor.any, GameColor.any);
        sid.compileConnectedCities(cn1);
        assertEquals(sid.connectedCities.size(), 1);
        assertEquals(sid.connectedCities.get(0).size(), 2);
        Connection cn2 = Connection.buildConnection("Vancouver", "Calgary", false, 3, GameColor.any, null);
        sid.compileConnectedCities(cn2);
        assertEquals(sid.connectedCities.size(), 1);
        assertEquals(sid.connectedCities.get(0).size(), 4);
        Connection cn6 = Connection.buildConnection("Portland", "San Francisco", true, 5, GameColor.green, GameColor.pink);
        sid.compileConnectedCities(cn6);
        assertEquals(sid.connectedCities.size(), 2);
        assertEquals(sid.connectedCities.get(0).size(), 4);
        assertEquals(sid.connectedCities.get(1).size(), 2);
        Connection cn3 = Connection.buildConnection("Seattle", "Portland", true, 1, GameColor.any, GameColor.any);
        sid.compileConnectedCities(cn3);
        assertEquals(sid.connectedCities.size(), 1);
        assertEquals(sid.connectedCities.get(0).size(), 8);
        Ticket t30 = Ticket.buildTicket("Vancouver", "Portland", 10);
        sid.tickets.add(t30);
        sid.scoreTickets();
        assertEquals(sid.score, 10);
    }

    public void testOutOfCards() {
        List<String> returnTickets1 = new ArrayList<>();
        List<String> returnTickets2 = new ArrayList<>();
        Board b = new Board(sid, "test");
        Player bob = new Player("bob");
        b.addPlayer(bob);
        b.startGame(sid.playerID);
        b.pickPlayType(sid.playerID, PlayType.drawTickets);
        b.drawTickets(sid.playerID);
        b.returnTickets(sid.playerID, returnTickets1);
        b.pickPlayType(bob.playerID, PlayType.drawTickets);
        b.drawTickets(bob.playerID);
        assertTrue(b.returnTickets(bob.playerID, returnTickets2));

        for (int i = 0; i < 97; i++) {
            b.discardedCardList.add(b.cardList.get(0));
            b.cardList.remove(0);
        }
        b.pickPlayType(sid.playerID, PlayType.drawCards);
        assertTrue(b.drawCard(sid.playerID, 0));
        if (b.getPlayerFromID(sid.playerID).cards.get(4).gameColor != GameColor.any) {
            if (b.fiveOpenCards.get(0).gameColor != GameColor.any)
                assertTrue(b.drawCard(sid.playerID, 0));
        } else {
            assertTrue(b.drawCard(sid.playerID, 1));
        }

        assertEquals(b.fiveOpenCards.size(), 5);

        b.pickPlayType(bob.playerID, PlayType.drawCards);
        assertTrue(b.drawCard(bob.playerID, 0));
        if (b.getPlayerFromID(bob.playerID).cards.get(4).gameColor != GameColor.any) {
            if (b.fiveOpenCards.get(0).gameColor != GameColor.any)
                assertTrue(b.drawCard(bob.playerID, 0));
        } else {
            assertTrue(b.drawCard(bob.playerID, 1));
        }

        assertEquals(b.fiveOpenCards.size(), 5);

    }

    public void testBuildWithLocos() {
        List<String> returnTickets1 = new ArrayList<>();
        List<String> returnTickets2 = new ArrayList<>();
        Board b = new Board(sid, "test");
        Player bob = new Player("bob");
        b.addPlayer(bob);
        b.startGame(sid.playerID);
        b.pickPlayType(sid.playerID, PlayType.drawTickets);
        b.drawTickets(sid.playerID);
        b.returnTickets(sid.playerID, returnTickets1);
        b.pickPlayType(bob.playerID, PlayType.drawTickets);
        b.drawTickets(bob.playerID);
        assertTrue(b.returnTickets(bob.playerID, returnTickets2));
        int locos = 0;
        for (Card card : b.getPlayerFromID(sid.playerID).cards) {
            if (card.gameColor == GameColor.any) {
                locos += 1;
            }
        }
        while (locos != 6) {
            Card card = new Card(GameColor.any);
            b.getPlayerFromID(sid.playerID).cards.add(card);
            locos += 1;
        }
        assertEquals(locos, 6);
        assertTrue(b.pickPlayType(sid.playerID, PlayType.buildTracks));
    }

    public void testTakeBothPathways() {
        List<String> returnTickets1 = new ArrayList<>();
        List<String> returnTickets2 = new ArrayList<>();
        Board b = new Board(sid, "test");
        Player bob = new Player("bob");
        b.addPlayer(bob);
        b.startGame(sid.playerID);
        b.pickPlayType(sid.playerID, PlayType.drawTickets);
        b.drawTickets(sid.playerID);
        b.returnTickets(sid.playerID, returnTickets1);
        b.pickPlayType(bob.playerID, PlayType.drawTickets);
        b.drawTickets(bob.playerID);
        assertTrue(b.returnTickets(bob.playerID, returnTickets2));
        for (int i = 0; i < 6; i++) {
            Card card = new Card(GameColor.red);
            b.getPlayerFromID(sid.playerID).cards.add(card);
        }
        b.pickPlayType(sid.playerID, PlayType.buildTracks);
        Connection connection = b.connectionList.get(0);
        Pathway pathway1 = connection.pathway1;
        Pathway pathway2 = connection.pathway2;
        assertTrue(b.buildTrack(sid.playerID, connection.connectionID, pathway2.pathwayID, GameColor.red, false));
        b.pickPlayType(bob.playerID, PlayType.drawCards);
        assertTrue(b.drawCard(bob.playerID, 5));
        assertTrue(b.drawCard(bob.playerID, 5));
        b.pickPlayType(sid.playerID, PlayType.buildTracks);
        assertTrue(b.buildTrack(sid.playerID, connection.connectionID, pathway1.pathwayID, GameColor.red, false));
    }
}
