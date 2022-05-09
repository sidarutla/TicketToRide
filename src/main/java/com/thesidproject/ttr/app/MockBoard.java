package com.thesidproject.ttr.app;

import java.util.List;
import java.util.UUID;

public class MockBoard {
    private String boardId;
    private String boardName;
    private String owningPlayerId;
    private List<PlayerData> players;

    public MockBoard(String boardName, MockPlayer owningPlayer) {
        this.boardId = UUID.randomUUID().toString();
        this.boardName = boardName;
        this.owningPlayerId = owningPlayer.getPlayerId();
        this.players = new java.util.ArrayList<>();
        PlayerData player = new PlayerData(owningPlayer.getPlayerId(),owningPlayer.getPlayerName(), "Red");
        this.players.add(player);
    }

    public boolean addPlayer(MockPlayer newPlayer) {
        PlayerData thePlayer = players.stream().filter(p -> p.getPlayerId().equalsIgnoreCase(newPlayer.getPlayerId())).findFirst().orElse(null);
        if(thePlayer != null) {
            return true;
        } else if(players.size() >= 4) {
            return false;
        } else {
            PlayerData player = new PlayerData(newPlayer.getPlayerId(), newPlayer.getPlayerName(), "Red");
            players.add(player);
            return true;
        }
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
}

