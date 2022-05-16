package com.thesidproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Board {

    private String boardID;
    private String boardName;

    List<Ticket> ticketList = new BoardBuilder().createTickets();
    List<Card> cardList = new BoardBuilder().createCards();
    List<Card> discardedCardList = new ArrayList<>();
    List<Connection> connectionList = new BoardBuilder().createConnections();
    List<Card> fiveOpenCards = new ArrayList<>();


    List<GamePlayer> gamePlayerList = new ArrayList<>();
    List<GamePlayer> leaderboard = new ArrayList<>();
    GameState gameState;
    String owningPlayerID = null;
    int round = 1;
    String currentPlayerID;
    PlayType currentPlayType;
    Boolean isTurnInProgress = false;
    int cardsDrawn = 0;
    String finalPlayerID = null;

    public Board(Player owner, String boardName) {
        GamePlayer ownerGamePlayer = new GamePlayer(owner.playerID, owner.name, getUnusedColor());
        gamePlayerList.add(ownerGamePlayer);
        owningPlayerID = owner.playerID;
        gameState = GameState.initializing;
        boardID = UUID.randomUUID().toString();
        this.boardName = boardName;
    }

    public boolean addPlayer(Player player) {

        if (getPlayerFromID(player.playerID) != null) {
            return true;
        }

        if (gameState == GameState.initializing && gamePlayerList.size() < 5) {
            GamePlayer gamePlayer = new GamePlayer(player.playerID, player.name, getUnusedColor());
            gamePlayerList.add(gamePlayer);
            return true;
        }

        return false;
    }

    public GamePlayer getPlayerFromID(String playerID) {
        for (GamePlayer gamePlayer : gamePlayerList) {
            if (gamePlayer.playerID.equals(playerID)) {
                return gamePlayer;
            }
        }
        return null;
    }

    public Connection getConnectionFromID(String connectionID) {
        for (Connection connection : connectionList) {
            if (connection.connectionID.equals(connectionID)) {
                return connection;
            }
        }
        return null;
    }

    public Pathway getPathwayFromID(String pathwayID, Connection connection) {
        if (connection == null) {
            return null;
        }
        if (connection.pathway1.pathwayID.equals(pathwayID)) {
            return connection.pathway1;
        }
        if (connection.pathway2.pathwayID.equals(pathwayID)) {
            return connection.pathway2;
        }
        return null;
    }

    public boolean startGame(String playerID) {
        if (playerID.equals(owningPlayerID) && gameState == GameState.initializing && gamePlayerList.size() > 1) {
            gameState = GameState.started;
            currentPlayerID = gamePlayerList.get(0).playerID;
            shuffleTickets();
            shuffleCards();
            distributeCards();
            openFiveCards();
            return true;
        }
        return false;
    }


    private PlayerColor getUnusedColor() {
        PlayerColor[] allColors = PlayerColor.values();
        for (PlayerColor allColor : allColors) {
            boolean isColorUsed = false;
            for (GamePlayer gamePlayer : gamePlayerList) {
                if (allColor == gamePlayer.playerColor) {
                    isColorUsed = true;
                    break;
                }
            }
            if (!isColorUsed) {
                return allColor;
            }
        }
        return null;
    }

    public void shuffleTickets() {
        Collections.shuffle(ticketList);
    }

    public void shuffleCards() {
        Collections.shuffle(cardList);
    }

    public void distributeCards() {
        for (GamePlayer gamePlayer : gamePlayerList) {
            gamePlayer.addCards(cardList);
        }
    }

    public void openFiveCards() {
        int missingCards = 5 - fiveOpenCards.size();
        List<Card> cardsNeeded = new ArrayList<>(cardList.subList(0, missingCards));
        fiveOpenCards.addAll(cardsNeeded);
        cardList.removeAll(cardsNeeded);

        while (has3Locos()) {
            cardList.addAll(fiveOpenCards);
            shuffleCards();
            fiveOpenCards = new ArrayList<>(cardList.subList(0, 5));
            cardList.removeAll(fiveOpenCards);
        }
    }

    public boolean has3Locos() {
        int locos = 0;
        for (Card card : fiveOpenCards) {
            if (card.gameColor == GameColor.any) {
                locos += 1;
            }
        }
        return locos >= 3;
    }

    public void checkOpenCards() {
        System.out.println("Open cards:");
        for (Card fiveOpenCard : fiveOpenCards) {
            System.out.println(fiveOpenCard);
        }
        System.out.println();
    }

    public Card getCard(TakeCard card) {

        int cardIndex = card.ordinal();

        Card wantedCard;
        if (cardIndex <= 4) {
            wantedCard = fiveOpenCards.get(cardIndex);
            fiveOpenCards.remove(cardIndex);
            fiveOpenCards.add(cardList.get(0));
        } else {
            wantedCard = cardList.get(0);
        }
        cardList.remove(0);
        return wantedCard;
    }

    public boolean isTakeCardValid(TakeCard takeCard, boolean isFirstTurn) {
        return isFirstTurn || takeCard.ordinal() >= 5 || !fiveOpenCards.get(takeCard.ordinal()).isLocomotive();
    }


    public boolean pickPlayType(String playerID, PlayType playType) {

        if (round == 1 && playType != PlayType.drawTickets) {
            return false;
        }

        if (isTurnInProgress) {
            return false;
        }
        if (!playerID.equals(currentPlayerID)) {
            return false;
        }
        if (gameState != GameState.started) {
            return false;
        }
        currentPlayType = playType;
        isTurnInProgress = false;
        return true;
    }

    public boolean resetPlayType(String playerID) {
        if (!playerID.equals(currentPlayerID)) {
            return false;
        }
        if (isTurnInProgress) {
            return false;
        }
        currentPlayType = null;

        return true;
    }

    public boolean drawTickets(String playerID) {
        if (!playerID.equals(currentPlayerID)) {
            return false;
        }

        if (currentPlayType != PlayType.drawTickets) {
            return false;
        }

        if (isTurnInProgress) {
            return false;
        }

        if (ticketList.size() < 3) {
            return false;
        }
        List<Ticket> drawnTickets = new ArrayList<>(ticketList.subList(0, 3));
        ticketList.removeAll(drawnTickets);
        GamePlayer gamePlayer = getPlayerFromID(playerID);
        gamePlayer.drawnTickets = drawnTickets;
        isTurnInProgress = true;
        return true;
    }

    public boolean returnTickets(String playerID, List<String> returnedTicketIDs) {
        if (!playerID.equals(currentPlayerID)) {
            return false;
        }

        if (currentPlayType != PlayType.drawTickets) {
            return false;
        }

        if (!isTurnInProgress) {
            return false;
        }

        if (round == 1 && returnedTicketIDs.size() > 1) {
            return false;
        }

        if (returnedTicketIDs.size() > 2) {
            return false;
        }
        GamePlayer gamePlayer = getPlayerFromID(playerID);
        List<Ticket> returnedTickets = new ArrayList<>();

        for (String returnedTicketID : returnedTicketIDs) {
            boolean returnedTicketMatches = false;
            for (int j = 0; j < gamePlayer.drawnTickets.size(); j++) {
                if (returnedTicketID.equals(gamePlayer.drawnTickets.get(j).ticketID)) {
                    returnedTicketMatches = true;
                    break;
                }
            }
            if (!returnedTicketMatches) {
                return false;
            }
        }

        for (String returnedTicketID : returnedTicketIDs) {
            for (int j = 0; j < gamePlayer.drawnTickets.size(); j++) {
                if (returnedTicketID.equals(gamePlayer.drawnTickets.get(j).ticketID)) {
                    returnedTickets.add(gamePlayer.drawnTickets.get(j));
                }
            }
        }

        gamePlayer.drawnTickets.removeAll(returnedTickets);
        ticketList.addAll(returnedTickets);
        shuffleTickets();
        gamePlayer.tickets.addAll(gamePlayer.drawnTickets);
        gamePlayer.drawnTickets.clear();

        endTurn(playerID);
        return true;
    }

    public void endTurn(String playerID) {
        cardsDrawn = 0;
        isTurnInProgress = false;
        currentPlayType = null;
        GamePlayer gamePlayer = getPlayerFromID(playerID);
        int nextPlayerIndex = gamePlayerList.indexOf(gamePlayer) + 1;
        if (nextPlayerIndex == gamePlayerList.size()) {
            currentPlayerID = gamePlayerList.get(0).playerID;
            round += 1;
        } else {
            currentPlayerID = gamePlayerList.get(nextPlayerIndex).playerID;
        }

        if (playerID.equalsIgnoreCase(finalPlayerID)) {
            endGame();;
        }
        if (gamePlayer.tracks <= 2 && finalPlayerID == null) {
            finalPlayerID = playerID;
        }
    }

    public void endGame() {
        gameState = GameState.finished;
        leaderboard.addAll(gamePlayerList);
    }

    public boolean drawCard(String playerID, int index) {
        if (!playerID.equals(currentPlayerID)) {
            return false;
        }

        if (currentPlayType != PlayType.drawCards) {
            return false;
        }

        if (index < 0 || index > 5) {
            return false;
        }
        if (cardList.size() < 2) {
            cardList.addAll(discardedCardList);
            discardedCardList.clear();
            shuffleCards();
        }

        if (cardList.size() < 2) {
            return false;
        }
        if (index < 5) {
            Card wantedCard = fiveOpenCards.get(index);
            if (cardsDrawn > 0 && wantedCard.gameColor == GameColor.any) {
                return false;
            }
        }


        isTurnInProgress = true;
        GamePlayer gamePlayer = getPlayerFromID(playerID);
        if (index < 5) {
            Card cardWanted = fiveOpenCards.remove(index);
            if (cardWanted.gameColor == GameColor.any) {
                cardsDrawn += 2;
            } else {
                cardsDrawn += 1;
            }
            gamePlayer.cards.add(cardWanted);
            openFiveCards();
        } else {
            Card cardWanted = cardList.remove(0);
            gamePlayer.cards.add(cardWanted);
            cardsDrawn += 1;
        }

        if (cardsDrawn == 2) {
            endTurn(playerID);
        }
        return true;
    }


    public boolean buildTrack(String playerID, String connectionID, String pathwayID, GameColor colorToUse, boolean useLocos) {
        GamePlayer gamePlayer = getPlayerFromID(playerID);
        Connection connection = getConnectionFromID(connectionID);
        Pathway pathway = getPathwayFromID(pathwayID, connection);
        if (!playerID.equals(currentPlayerID)) {
            return false;
        }

        if (currentPlayType != PlayType.buildTracks) {
            return false;
        }

        if (isTurnInProgress) {
            return false;
        }

        if (connection == null || pathway == null) {
            return false;
        }

        if (pathway.gamePlayer != null) {
            return false;
        }

        if (gamePlayer.tracks < pathway.tracks) {
            return false;
        }

        List<Card> usableCards = getUsableCards(gamePlayer, pathway.tracks, colorToUse, useLocos);
        if (usableCards.size() < pathway.tracks) {
            return false;
        }

        pathway.gamePlayer = gamePlayer;
        gamePlayer.cards.removeAll(usableCards);
        discardedCardList.addAll(usableCards);
        gamePlayer.tracks -= pathway.tracks;
        gamePlayer.score += getPoints(pathway.tracks);
        endTurn(playerID);
        return true;
    }

    public List<Card> getUsableCards(GamePlayer gamePlayer, int tracks, GameColor colorToUse, boolean useLocos) {
        List<Card> usableCards = new ArrayList<>();

        for (Card card : gamePlayer.cards) {
            if (card.gameColor == colorToUse) {
                usableCards.add(card);
            }
            if (usableCards.size() == tracks) {
                return usableCards;
            }
        }


        if (useLocos) {
            for (Card card : gamePlayer.cards) {
                if (card.gameColor == GameColor.any) {
                    usableCards.add(card);
                }
                if (usableCards.size() == tracks) {
                    break;
                }
            }
        }
        return usableCards;
    }

    public int getPoints(int tracks) {
        if (tracks == 1) {
            return 1;
        }
        if (tracks == 2) {
            return 2;
        }
        if (tracks == 3) {
            return 4;
        }
        if (tracks == 4) {
            return 7;
        }
        if (tracks == 5) {
            return 10;
        }
        else {
            return 15;
        }
    }

    public String getBoardID() {
        return boardID;
    }

    public void setBoardID(String boardID) {
        this.boardID = boardID;
    }

    public String getBoardName() {
        return boardName;
    }

    public void setBoardName(String boardName) {
        this.boardName = boardName;
    }

    public List<GamePlayer> getPlayers() {
        return gamePlayerList;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public String getOwningPlayerID() {
        return owningPlayerID;
    }

    public void setOwningPlayerID(String owningPlayerID) {
        this.owningPlayerID = owningPlayerID;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getCurrentPlayerID() {
        return currentPlayerID;
    }

    public void setCurrentPlayerID(String currentPlayerID) {
        this.currentPlayerID = currentPlayerID;
    }

    public PlayType getCurrentPlayType() {
        return currentPlayType;
    }

    public void setCurrentPlayType(PlayType currentPlayType) {
        this.currentPlayType = currentPlayType;
    }

    public List<Card> getFiveOpenCards() {
        return fiveOpenCards;
    }

    public List<Connection> getConnections() {
        return connectionList;
    }

    public List<GamePlayer> getLeaderboard() {
        return leaderboard;
    }
}






