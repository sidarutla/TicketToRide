package com.thesidproject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Board {

    private String boardID;
    private String boardName;

    List<Ticket> ticketList = new BoardBuilder().createTickets();
    List<Card> cardList = new BoardBuilder().createCards();
    List<Connection> connectionList = new BoardBuilder().createConnections();
    List<Card> fiveOpenCards = new ArrayList<>();

    List<GamePlayer> gamePlayerList = new ArrayList<>();
    GameState gameState;
    String owningPlayerID = null;
    int round = 1;
    String currentPlayerID;
    PlayType currentPlayType;
    Boolean isTurnInProgress;

    public Board(Player owner, String boardName) {
        GamePlayer ownerGamePlayer = new GamePlayer(owner.playerID, owner.name, getUnusedColor());
        gamePlayerList.add(ownerGamePlayer);
        owningPlayerID = owner.playerID;
        gameState = GameState.initializing;
        boardID = UUID.randomUUID().toString();
        this.boardName = boardName;
    }

    public boolean addPlayer(Player player) {

        //TODO: SID: Add player should not add the player, if the player is already in the game and it should return true.
        if (gameState == GameState.initializing && gamePlayerList.size() < 5) {
            GamePlayer gamePlayer = new GamePlayer(player.playerID, player.name, getUnusedColor());
            gamePlayerList.add(gamePlayer);
            return true;
        }
        return false;
    }

    private GamePlayer getPlayerFromID(String playerID) {
        for (GamePlayer gamePlayer : gamePlayerList) {
            if (gamePlayer.playerID.equals(playerID)) {
                return gamePlayer;
            }
        }
        return null;
    }

    public boolean startGame(String playerID) {
        if (playerID.equals(owningPlayerID) && gameState == GameState.initializing && gamePlayerList.size() > 1) {
            gameState = GameState.started;
            currentPlayerID = gamePlayerList.get(0).playerID;
//            shuffleTickets();
//            shuffleCards();
//            distributeCards();
//            openFiveCards();
//            playYourTurn();
            return true;
        }
        return false;
    }


    private PlayerColor getUnusedColor() {
        PlayerColor[] allColors = PlayerColor.values();
        boolean isColorUsed = false;
        for (PlayerColor allColor : allColors) {
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

//    public void distributeTickets() {
////        for (Player player : gamePlayerList) {
////            player.drawTickets(ticketList);
//            for (int j = 0; j < 23; j++) {
//                System.out.println();
//            }
//        }
//    }

    public void distributeCards() {
        for (GamePlayer gamePlayer : gamePlayerList) {
            gamePlayer.addCards(cardList);
        }
    }

    public void openFiveCards() {
        int locos = 0;
        boolean threeLocos = true;

        while (threeLocos) {
            fiveOpenCards = new ArrayList<>(cardList.subList(0, 5));
            cardList.removeAll(fiveOpenCards);

            for (int i = 0; i < 5; i++) {
                Card card = fiveOpenCards.get(i);
                if (card.gameColor == GameColor.any) {
                    locos += 1;
                }
            }
            if (locos < 3) {
                threeLocos = false;
            } else {
                cardList.addAll(fiveOpenCards);
                shuffleCards();
            }
        }
    }

//    public void playYourTurn() {
//        boolean isGamePlaying = true;
//        int i = 0;
//        List<Integer> scores = new ArrayList<>();
//        while (isGamePlaying) {
//            if (gamePlayerList.get(i).tracks <= 2) {
//                gamePlayerList.get(i).playTurn(this, ticketList, connectionList);
//                System.out.println(gamePlayerList.get(i));
//                for (Player player : gamePlayerList) {
//                    for (int k = 0; k < player.tickets.size(); k++) {
//                        player.score -= player.tickets.get(k).value;
//                    }
//                    System.out.println("Player " + player.name + "'s score: " + player.score);
//                    scores.add(player.score);
//                }
//                int highestScore = Collections.max(scores);
//                boolean winningPlayerFound = false;
//                for (Player player : gamePlayerList) {
//                    if (player.score == highestScore && !winningPlayerFound) {
//                        System.out.println("Player " + player.name + " wins!");
//                        winningPlayerFound = true;
//                    }
//                }
//                isGamePlaying = false;
//            } else {
//                gamePlayerList.get(i).playTurn(this, ticketList, connectionList);
//                if (i < gamePlayerList.size() - 1) {
//                    i++;
//                } else {
//                    i = 0;
//                }
//            }
//        }
//    }

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


    public boolean pickPlayType(String PlayerID, PlayType playType) {

        if (round == 1 && playType != PlayType.drawTickets && !isTurnInProgress) {
            return false;
        }
        if (!PlayerID.equals(currentPlayerID) || gameState != GameState.started) {
            return false;
        }
        currentPlayType = playType;
        isTurnInProgress = false;
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

        currentPlayerID = null; //Get next playerId given a playerId.
        isTurnInProgress = false;
        currentPlayType = null;

        return true;
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
}






