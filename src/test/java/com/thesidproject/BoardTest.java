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
}
