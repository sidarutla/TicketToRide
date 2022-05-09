package com.thesidproject.ttr.app;

import com.thesidproject.Board;
import com.thesidproject.BoardBuilder;
import com.thesidproject.GameColor;
import com.thesidproject.GameState;

import java.util.List;
import java.util.UUID;

public class MockBoard {
    private String boardId;
    private String boardName;
    private String owningPlayerId;
    private List<PlayerData> players;
    private GameState gameState;

    public MockBoard(String boardName, MockPlayer owningPlayer) {
        this.boardId = UUID.randomUUID().toString();
        this.boardName = boardName;
        this.owningPlayerId = owningPlayer.getPlayerId();
        this.players = new java.util.ArrayList<>();
        this.gameState = GameState.initializing;
        PlayerData player = new PlayerData(owningPlayer.getPlayerId(),owningPlayer.getPlayerName(), GameColor.yellow);
        this.players.add(player);
    }

    public boolean addPlayer(MockPlayer newPlayer) {
        PlayerData thePlayer = players.stream().filter(p -> p.getPlayerId().equalsIgnoreCase(newPlayer.getPlayerId())).findFirst().orElse(null);
        if(thePlayer != null) {
            return true;
        }


        if(this.gameState != GameState.initializing) {
            return false;
        }

        if(players.size() >= 4) {
            return false;
        }

        BoardBuilder boardBuilder = new BoardBuilder();
        List<GameColor> usedColors = players.stream().map(p -> p.getPlayerColor()).collect(java.util.stream.Collectors.toList());
        GameColor usedColor = boardBuilder.getUnusedColor(usedColors);
        PlayerData player = new PlayerData(newPlayer.getPlayerId(), newPlayer.getPlayerName(), usedColor);
        players.add(player);
        return true;

    }

    public boolean startGame(String playerId) {
        if(this.gameState != GameState.initializing) {
            return false;
        }

        if(!this.owningPlayerId.equalsIgnoreCase(playerId)) {
            return false;
        }

        if(this.players == null || this.players.size() < 2) {
            return false;
        }

        this.gameState = GameState.started;
        return true;
    }

    public String getBoardId() {
        return boardId;
    }

    public void setBoardId(String boardId) {
        this.boardId = boardId;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public String getOwningPlayerId() {
        return owningPlayerId;
    }

    public void setOwningPlayerId(String owningPlayerId) {
        this.owningPlayerId = owningPlayerId;
    }

    public List<PlayerData> getPlayers() {
        return players;
    }

    public void setPlayers(List<PlayerData> players) {
        this.players = players;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}

