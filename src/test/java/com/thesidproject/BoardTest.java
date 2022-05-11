package com.thesidproject;

import junit.framework.TestCase;

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
}