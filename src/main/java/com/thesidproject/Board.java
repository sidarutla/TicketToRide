package com.thesidproject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {

    List<Ticket> ticketList = new BoardBuilder().createTickets();
    List<Card> cardList = new BoardBuilder().createCards();
    List<Connection> connectionList = new BoardBuilder().createConnections();
    List<Card> fiveOpenCards = new ArrayList<>();

    List<GamePlayer> gamePlayerList = new ArrayList<>();
    GameState gameState;
    String owningPlayerID = null;
    int round = 0;

    public Board(Player owner) {
        GamePlayer ownerGamePlayer = new GamePlayer(owner.playerID, owner.name, getUnusedColor());
        gamePlayerList.add(ownerGamePlayer);
        owningPlayerID = owner.playerID;
        gameState = GameState.initializing;
    }

    public String addPlayer(Player player) {
        if (gameState == GameState.initializing && gamePlayerList.size() < 5) {
            GamePlayer gamePlayer = new GamePlayer(player.playerID, player.name, getUnusedColor());
            gamePlayerList.add(gamePlayer);
        }
        return null;
    }

    public void startGame(String playerID) {
        if (playerID.equals(owningPlayerID) && gameState == GameState.initializing && gamePlayerList.size() > 1) {
            gameState = GameState.started;
//            shuffleTickets();
//            shuffleCards();
//            distributeCards();
//            openFiveCards();
//            playYourTurn();
        }
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
}






