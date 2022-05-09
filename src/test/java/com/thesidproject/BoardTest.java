package com.thesidproject;

import junit.framework.TestCase;

public class BoardTest extends TestCase {

    Player sid = new Player("Sid");

    public void testBoardCreation() {
        Board b = new Board(sid);
        assertEquals("Number of players", 1, b.gamePlayerList.size());
        assertEquals("Check owning player", sid.playerID, b.owningPlayerID);
        assertEquals("Check game state", GameState.initializing, b.gameState);
    }

    public void testAddPlayer() {
        Board b = new Board(sid);
        Player bob = new Player("Bob");
        b.addPlayer(bob);
        assertEquals("Number of players,", 2, b.gamePlayerList.size());
        assertEquals("Check owning player", sid.playerID, b.owningPlayerID);
    }

    public void testStartGame() {
        Board b = new Board(sid);
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
}