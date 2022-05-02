import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Player {

    final String name;

    final PlayerColor playerColor;

    int tracks = 45;
    int score = 0;
    ArrayList<Ticket> tickets;
    ArrayList<Card> cards;
    List<List<String>> connectedCities = new ArrayList<>();

    public Player(String inputName, PlayerColor inputColor) {
        this.name = inputName;
        this.playerColor = inputColor;
        this.tickets = new ArrayList<>();
        this.cards = new ArrayList<>();
    }

    public void print() {
        System.out.println("Player " + name + ", here are your stats:");
        System.out.println("score:");
        System.out.println(score);
        System.out.println();
        System.out.println("number of tracks:");
        System.out.println(tracks);
        System.out.println();
        System.out.println("tickets:");
        for (Ticket ticket : tickets) {
            System.out.println(ticket);
        }
        System.out.println();
        System.out.println("cards:");
        for (Card card : cards) {
            System.out.println(card);
        }
        System.out.println();
    }


    public void drawTickets(List<Ticket> ticketList) {
        for (int i = 0; i < 3; i++) {
            tickets.add(ticketList.get(0));
            ticketList.remove(0);
            System.out.println(tickets.get(i));
        }
    }

    public void addCards(List<Card> cardList) {
        for (int i = 0; i < 4; i++) {
            cards.add(cardList.get(0));
            cardList.remove(0);
        }
    }

    public void playTurn(Board board, List<Ticket> ticketList, List<Connection> connectionList) {
        System.out.println("Player " + name + ", type 1 to begin your turn.");
        boolean isValidInput5 = false;
        int inputIndex5 = -1;
        while (!isValidInput5) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = reader.readLine();
                inputIndex5 = Integer.parseInt(input);
                if (inputIndex5 == 1) {
                    isValidInput5 = true;
                }
            } catch (Exception e) {
            }
        }
        print();
        PlayType playType = getPlayType();

        if (playType == PlayType.drawCards) {
            TakeCard takeCard = getTakeCard(board);
            Card drawnCard = board.getCard(takeCard);
            cards.add(drawnCard);
            System.out.println("Player " + name + ", you got a " + drawnCard.cardColor + ".");
            System.out.println();

            if (takeCard.ordinal() > 4 || !drawnCard.isLocomotive()) {
                //Can't take locomotive..
                takeCard = getTakeCard(board);
                while (board.isTakeCardValid(takeCard, false) == false) {
                    takeCard = getTakeCard(board);
                }
                Card secondCard = board.getCard(takeCard);
                cards.add(secondCard);
                System.out.println("Player " + name + ", you got a " + drawnCard.cardColor + ".");
                System.out.println();
            }
        } else if (playType == PlayType.drawTickets) {
            List<Ticket> drawnTickets = new ArrayList<>();
            System.out.println("Player " + name + ", how many tickets would you like to return? ");
            for (int i = 0; i < 3; i++) {
                drawnTickets.add(ticketList.get(i));
                System.out.println(ticketList.get(i));
                ticketList.remove(i);
            }
            boolean isValidInput = false;
            int inputIndex = -1;
            while (!isValidInput) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String input = reader.readLine();
                    inputIndex = Integer.parseInt(input);
                    if (inputIndex < 3 && inputIndex > -1) {
                        isValidInput = true;
                    }
                } catch (Exception e) {
                }
            }
            if (inputIndex == 1) {
                boolean isValidInput2 = false;
                int inputIndex2 = -1;
                while (!isValidInput2) {
                    System.out.println("Player " + name + ", return a ticket:");
                    for (int k = 0; k < drawnTickets.size(); k++) {
                        System.out.println(k + 1 + " = " + drawnTickets.get(k));
                    }
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String input = reader2.readLine();
                        inputIndex2 = Integer.parseInt(input);
                        if (inputIndex2 < 4 && inputIndex2 > -1) {
                            isValidInput2 = true;
                        }
                    } catch (Exception e) {
                    }
                }
                ticketList.add(drawnTickets.get(inputIndex2 - 1));
                drawnTickets.remove(inputIndex2 - 1);
                int size = drawnTickets.size();
                for (int j = 0; j < size; j++) {
                    tickets.add(drawnTickets.get(0));
                    drawnTickets.remove(0);
                }
            } else if (inputIndex == 2) {
                boolean isValidInput2 = false;
                int inputIndex2 = -1;
                while (!isValidInput2) {
                    System.out.println("Player " + name + ", return a ticket:");
                    for (int k = 0; k < drawnTickets.size(); k++) {
                        System.out.println(k + 1 + " = " + drawnTickets.get(k));
                    }
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String input = reader2.readLine();
                        inputIndex2 = Integer.parseInt(input);
                        if (inputIndex2 < 4 && inputIndex2 > 0) {
                            isValidInput2 = true;
                        }
                    } catch (Exception e) {
                    }
                }
                ticketList.add(drawnTickets.get(inputIndex2 - 1));
                drawnTickets.remove(inputIndex2 - 1);
                boolean isValidInput4 = false;
                int inputIndex4 = -1;
                while (!isValidInput4) {
                    System.out.println("Player " + name + ", return another ticket:");
                    for (int k = 0; k < drawnTickets.size(); k++) {
                        System.out.println(k + 1 + " = " + drawnTickets.get(k));
                    }
                    BufferedReader reader4 = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String input = reader4.readLine();
                        inputIndex4 = Integer.parseInt(input);
                        if (inputIndex4 < 3 && inputIndex4 > 0) {
                            isValidInput4 = true;
                        }
                    } catch (Exception e) {
                    }
                }
                ticketList.add(drawnTickets.get(inputIndex4 - 1));
                drawnTickets.remove(inputIndex4 - 1);
                int size3 = drawnTickets.size();
                for (int j = 0; j < size3; j++) {
                    tickets.add(drawnTickets.get(0));
                    drawnTickets.remove(0);
                }
            } else {
                for (int i = 0; i < drawnTickets.size(); ) {
                    tickets.add(drawnTickets.get(0));
                    drawnTickets.remove(0);
                }
            }
        } else if (playType == PlayType.buildTracks) {
            boolean isValidInput = false;
            int inputIndex = -1;
            while (!isValidInput) {

                System.out.println("Player " + name + ", where would you like to build tracks?");
                for (int i = 0; i < connectionList.size(); i++) {
                    System.out.println(i + 1 + " = " + connectionList.get(i));
                }
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                try {
                    String input = reader.readLine();
                    inputIndex = Integer.parseInt(input);
                    if (inputIndex < 79 && inputIndex > 0) {
                        isValidInput = true;
                    }
                } catch (Exception e) {
                }
            }
            if (connectionList.get(inputIndex - 1).pathway1.open == true || (connectionList.get(inputIndex - 1).pathway2 != null && connectionList.get(inputIndex - 1).pathway2.open == true)) {

                System.out.println("Player " + name + ", which pathway would you like to build on?");
                if (connectionList.get(inputIndex - 1).pathway1.open == true) {
                    System.out.println(connectionList.get(inputIndex - 1).pathway1);
                }
                if (connectionList.get(inputIndex - 1).pathway2 != null && connectionList.get(inputIndex - 1).pathway2.open == true) {
                    System.out.println(connectionList.get(inputIndex - 1).pathway2);
                }
                boolean isValidInput2 = false;
                int inputIndex2 = -1;
                while (!isValidInput2) {


                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
                    try {
                        String input2 = reader2.readLine();
                        inputIndex2 = Integer.parseInt(input2);
                        if ((connectionList.get(inputIndex - 1).pathway1.open == false || (connectionList.get(inputIndex - 1).pathway2 == null || connectionList.get(inputIndex - 1).pathway2.open == false)) && inputIndex2 == 1) {
                            isValidInput2 = true;
                        } else if (connectionList.get(inputIndex - 1).pathway1.open == true && connectionList.get(inputIndex - 1).pathway2.open == true && (inputIndex2 == 1 || inputIndex2 == 2)) {
                            if (inputIndex2 < 3 && inputIndex2 > 0) {
                                isValidInput2 = true;
                            }
                        }
                    } catch (Exception e) {
                    }
                }
                List<Card> usableCards = new ArrayList<>();
                if (inputIndex2 == 1 && connectionList.get(inputIndex - 1).pathway1.open == true) {
                    for (int i = 0; i < cards.size(); i++) {
                        if (cards.get(i).cardColor == CardColor.locomotive) {
                            usableCards.add(cards.get(i));
                            cards.remove(i);
                            i -= 1;
                        }
                    }
                    for (int i = 0; i < cards.size(); i++) {
                        if (cards.get(i).isColorMatching(connectionList.get(inputIndex - 1).pathway1)) {
                            usableCards.add(cards.get(i));
                            cards.remove(i);
                            i -= 1;
                        }
                    }
                    int usableCardSize = usableCards.size();
                    if (connectionList.get(inputIndex - 1).pathway1.color == TrackColor.grey) {
                        for (int i = 0; i < usableCardSize; i++) {
                            cards.add(usableCards.get(0));
                            usableCards.remove(0);
                        }
                        List<Card> redCards = new ArrayList<>();
                        List<Card> orangeCards = new ArrayList<>();
                        List<Card> yellowCards = new ArrayList<>();
                        List<Card> greenCards = new ArrayList<>();
                        List<Card> blueCards = new ArrayList<>();
                        List<Card> pinkCards = new ArrayList<>();
                        List<Card> blackCards = new ArrayList<>();
                        List<Card> whiteCards = new ArrayList<>();
                        List<Card> locoCards = new ArrayList<>();
                        int cardSize = cards.size();
                        for (int i = 0; i < cardSize; i++) {
                            if (cards.get(0).cardColor == CardColor.red) {
                                redCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.orange) {
                                orangeCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.yellow) {
                                yellowCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.green) {
                                greenCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.blue) {
                                blueCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.pink) {
                                pinkCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.black) {
                                blackCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.white) {
                                whiteCards.add(cards.get(0));
                                cards.remove(0);
                            } else {
                                locoCards.add(cards.get(0));
                                cards.remove(0);
                            }
                        }
                        if (redCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks || orangeCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks || yellowCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks || greenCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks || blueCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks || pinkCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks || blackCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks || whiteCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                            boolean isValidInput3 = false;
                            int inputIndex3 = -1;
                            while (!isValidInput3) {
                                System.out.println("Player " + name + ", this pathway is grey. Which color would you like to use?");
                                System.out.println("Red");
                                System.out.println("Orange");
                                System.out.println("Yellow");
                                System.out.println("Green");
                                System.out.println("Blue");
                                System.out.println("Pink");
                                System.out.println("Black");
                                System.out.println("White");
                                System.out.println("Locomotives");


                                BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
                                try {
                                    String input3 = reader3.readLine();
                                    inputIndex3 = Integer.parseInt(input3);
                                    if (inputIndex3 < 10 && inputIndex3 > 0) {
                                        isValidInput3 = true;
                                    }
                                } catch (Exception e) {
                                }
                            }
                            if (inputIndex3 == 1) {
                                if (redCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                        for (int i = 0; i < redCards.size(); ) {
                                            locoCards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway1.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway1.open = false;
                                        connectionList.get(inputIndex - 1).pathway1.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway1.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway1.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 2) {
                                if (orangeCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            locoCards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway1.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway1.open = false;
                                        connectionList.get(inputIndex - 1).pathway1.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway1.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway1.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 3) {
                                if (yellowCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            locoCards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway1.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway1.open = false;
                                        connectionList.get(inputIndex - 1).pathway1.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway1.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway1.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 4) {
                                if (greenCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                        for (int i = 0; i < greenCards.size(); ) {
                                            locoCards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway1.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway1.open = false;
                                        connectionList.get(inputIndex - 1).pathway1.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway1.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway1.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 5) {
                                if (blueCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway1.tracks)
                                        for (int i = 0; i < blueCards.size(); ) {
                                            locoCards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                    while (locoCards.size() > connectionList.get(inputIndex - 1).pathway1.tracks) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    connectionList.get(inputIndex - 1).pathway1.open = false;
                                    connectionList.get(inputIndex - 1).pathway1.player = this;
                                    tracks -= connectionList.get(inputIndex - 1).pathway1.tracks;
                                    boolean connectionFound = false;
                                    if (connectedCities.size() > 0) {
                                        for (int i = 0; i < connectedCities.size(); i++) {
                                            if (connectionFound == false) {
                                                for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                    if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                        connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                        connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                        connectionFound = true;
                                                    }
                                                }
                                            }
                                        }
                                        if (connectionFound == false) {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);

                                        }
                                    } else {
                                        List<String> stringList = new ArrayList<>();
                                        stringList.add(connectionList.get(inputIndex - 1).source);
                                        stringList.add(connectionList.get(inputIndex - 1).destination);
                                        connectedCities.add(stringList);
                                    }
                                    if (connectionList.get(inputIndex - 1).pathway1.tracks == 1) {
                                        score += 1;
                                    } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 2) {
                                        score += 2;
                                    } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 3) {
                                        score += 4;
                                    } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 4) {
                                        score += 7;
                                    } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 5) {
                                        score += 10;
                                    } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 6) {
                                        score += 15;
                                    }
                                    System.out.println("Player " + name + ", your track has been built.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }

                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 6) {
                                if (pinkCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            locoCards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway1.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway1.open = false;
                                        connectionList.get(inputIndex - 1).pathway1.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway1.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway1.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 7) {
                                if (blackCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                        for (int i = 0; i < blackCards.size(); ) {
                                            locoCards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway1.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway1.open = false;
                                        connectionList.get(inputIndex - 1).pathway1.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway1.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway1.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 8) {
                                if (whiteCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            locoCards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway1.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway1.open = false;
                                        connectionList.get(inputIndex - 1).pathway1.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway1.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway1.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 9) {
                                if (locoCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway1.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway1.open = false;
                                        connectionList.get(inputIndex - 1).pathway1.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway1.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway1.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            }

                        } else {
                            System.out.println("Player " + name + ", you do not have enough cards to build on this pathway.");
                            for (int i = 0; i < redCards.size(); ) {
                                cards.add(redCards.get(0));
                                redCards.remove(0);
                            }
                            for (int i = 0; i < orangeCards.size(); ) {
                                cards.add(orangeCards.get(0));
                                orangeCards.remove(0);
                            }
                            for (int i = 0; i < yellowCards.size(); ) {
                                cards.add(yellowCards.get(0));
                                yellowCards.remove(0);
                            }
                            for (int i = 0; i < greenCards.size(); ) {
                                cards.add(greenCards.get(0));
                                greenCards.remove(0);
                            }
                            for (int i = 0; i < blueCards.size(); ) {
                                cards.add(blueCards.get(0));
                                blueCards.remove(0);
                            }
                            for (int i = 0; i < pinkCards.size(); ) {
                                cards.add(pinkCards.get(0));
                                pinkCards.remove(0);
                            }
                            for (int i = 0; i < blackCards.size(); ) {
                                cards.add(blackCards.get(0));
                                blackCards.remove(0);
                            }
                            for (int i = 0; i < whiteCards.size(); ) {
                                cards.add(whiteCards.get(0));
                                whiteCards.remove(0);
                            }
                            for (int i = 0; i < locoCards.size(); ) {
                                cards.add(locoCards.get(0));
                                locoCards.remove(0);
                            }
                            playTurn(board, ticketList, connectionList);
                        }

                    } else if (usableCards.size() >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                        if (tracks >= connectionList.get(inputIndex - 1).pathway1.tracks) {
                            while (usableCards.size() > connectionList.get(inputIndex - 1).pathway1.tracks) {
                                cards.add(usableCards.get(0));
                                usableCards.remove(0);
                            }
                            connectionList.get(inputIndex - 1).pathway1.open = false;
                            connectionList.get(inputIndex - 1).pathway1.player = this;
                            tracks -= connectionList.get(inputIndex - 1).pathway1.tracks;
                            boolean connectionFound = false;
                            if (connectedCities.size() > 0) {
                                for (int i = 0; i < connectedCities.size(); i++) {
                                    if (connectionFound == false) {
                                        for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                            if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                connectionFound = true;
                                            }
                                        }
                                    }
                                }
                                if (connectionFound == false) {
                                    List<String> stringList = new ArrayList<>();
                                    stringList.add(connectionList.get(inputIndex - 1).source);
                                    stringList.add(connectionList.get(inputIndex - 1).destination);
                                    connectedCities.add(stringList);

                                }
                            } else {
                                List<String> stringList = new ArrayList<>();
                                stringList.add(connectionList.get(inputIndex - 1).source);
                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                connectedCities.add(stringList);
                            }
                            if (connectionList.get(inputIndex - 1).pathway1.tracks == 1) {
                                score += 1;
                            } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 2) {
                                score += 2;
                            } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 3) {
                                score += 4;
                            } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 4) {
                                score += 7;
                            } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 5) {
                                score += 10;
                            } else if (connectionList.get(inputIndex - 1).pathway1.tracks == 6) {
                                score += 15;
                            }
                            System.out.println("Player " + name + ", your track has been built.");
                        } else {
                            System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                            int usableCardsSize = usableCards.size();
                            for (int i = 0; i < usableCardsSize; i++) {
                                cards.add(usableCards.get(0));
                                usableCards.remove(0);
                            }
                            playTurn(board, ticketList, connectionList);
                        }
                    } else {
                        System.out.println("Player " + name + ", you do not have enough cards to build on this pathway.");
                        int usableCardsSize = usableCards.size();
                        for (int i = 0; i < usableCardsSize; i++) {
                            cards.add(usableCards.get(0));
                            usableCards.remove(0);
                        }
                        playTurn(board, ticketList, connectionList);
                    }

                } else {
                    for (int i = 0; i < cards.size(); i++) {
                        if (cards.get(i).cardColor == CardColor.locomotive) {
                            usableCards.add(cards.get(i));
                            cards.remove(i);
                            i -= 1;
                        }
                    }
                    for (int i = 0; i < cards.size(); i++) {
                        if (cards.get(i).isColorMatching(connectionList.get(inputIndex - 1).pathway2)) {
                            usableCards.add(cards.get(i));
                            cards.remove(i);
                            i -= 1;
                        }
                    }
                    int usableCardSize = usableCards.size();
                    if (connectionList.get(inputIndex - 1).pathway2.color == TrackColor.grey) {
                        for (int i = 0; i < usableCardSize; i++) {
                            cards.add(usableCards.get(0));
                            usableCards.remove(0);
                        }
                        List<Card> redCards = new ArrayList<>();
                        List<Card> orangeCards = new ArrayList<>();
                        List<Card> yellowCards = new ArrayList<>();
                        List<Card> greenCards = new ArrayList<>();
                        List<Card> blueCards = new ArrayList<>();
                        List<Card> pinkCards = new ArrayList<>();
                        List<Card> blackCards = new ArrayList<>();
                        List<Card> whiteCards = new ArrayList<>();
                        List<Card> locoCards = new ArrayList<>();
                        int cardSize = cards.size();
                        for (int i = 0; i < cardSize; i++) {
                            if (cards.get(0).cardColor == CardColor.red) {
                                redCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.orange) {
                                orangeCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.yellow) {
                                yellowCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.green) {
                                greenCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.blue) {
                                blueCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.pink) {
                                pinkCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.black) {
                                blackCards.add(cards.get(0));
                                cards.remove(0);
                            } else if (cards.get(0).cardColor == CardColor.white) {
                                whiteCards.add(cards.get(0));
                                cards.remove(0);
                            } else {
                                locoCards.add(cards.get(0));
                                cards.remove(0);
                            }
                        }
                        if (redCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks || orangeCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks || yellowCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks || greenCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks || blueCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks || pinkCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks || blackCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks || whiteCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                            boolean isValidInput3 = false;
                            int inputIndex3 = -1;
                            while (!isValidInput3) {
                                System.out.println("Player " + name + ", this pathway is grey. Which color would you like to use?");
                                System.out.println("Red");
                                System.out.println("Orange");
                                System.out.println("Yellow");
                                System.out.println("Green");
                                System.out.println("Blue");
                                System.out.println("Pink");
                                System.out.println("Black");
                                System.out.println("White");
                                System.out.println("Locomotives");


                                BufferedReader reader3 = new BufferedReader(new InputStreamReader(System.in));
                                try {
                                    String input3 = reader3.readLine();
                                    inputIndex3 = Integer.parseInt(input3);
                                    if (inputIndex3 < 10 && inputIndex3 > 0) {
                                        isValidInput3 = true;
                                    }
                                } catch (Exception e) {
                                }
                            }
                            if (inputIndex3 == 1) {
                                if (redCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                        for (int i = 0; i < redCards.size(); ) {
                                            locoCards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway2.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway2.open = false;
                                        connectionList.get(inputIndex - 1).pathway2.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway2.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway2.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 2) {
                                if (orangeCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            locoCards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway2.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway2.open = false;
                                        connectionList.get(inputIndex - 1).pathway2.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway2.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway2.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(locoCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 3) {
                                if (yellowCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            locoCards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway2.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway2.open = false;
                                        connectionList.get(inputIndex - 1).pathway2.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway2.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway2.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 4) {
                                if (greenCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                        for (int i = 0; i < greenCards.size(); ) {
                                            locoCards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway2.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway2.open = false;
                                        connectionList.get(inputIndex - 1).pathway2.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway2.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway2.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 5) {
                                if (blueCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                        for (int i = 0; i < blueCards.size(); ) {
                                            locoCards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway2.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway2.open = false;
                                        connectionList.get(inputIndex - 1).pathway2.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway2.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway2.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 6) {
                                if (pinkCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            locoCards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway2.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway2.open = false;
                                        connectionList.get(inputIndex - 1).pathway2.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway2.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway2.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 7) {
                                if (blackCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                        for (int i = 0; i < blackCards.size(); ) {
                                            locoCards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway2.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway2.open = false;
                                        connectionList.get(inputIndex - 1).pathway2.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway2.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway2.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 8) {
                                if (whiteCards.size() + locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            locoCards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway2.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway2.open = false;
                                        connectionList.get(inputIndex - 1).pathway2.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway2.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway2.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            } else if (inputIndex3 == 9) {
                                if (locoCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                    if (tracks >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                                        while (locoCards.size() > connectionList.get(inputIndex - 1).pathway2.tracks) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        connectionList.get(inputIndex - 1).pathway2.open = false;
                                        connectionList.get(inputIndex - 1).pathway2.player = this;
                                        tracks -= connectionList.get(inputIndex - 1).pathway2.tracks;
                                        boolean connectionFound = false;
                                        if (connectedCities.size() > 0) {
                                            for (int i = 0; i < connectedCities.size(); i++) {
                                                if (connectionFound == false) {
                                                    for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                                        if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                            connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                            connectionFound = true;
                                                        }
                                                    }
                                                }
                                            }
                                            if (connectionFound == false) {
                                                List<String> stringList = new ArrayList<>();
                                                stringList.add(connectionList.get(inputIndex - 1).source);
                                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                                connectedCities.add(stringList);

                                            }
                                        } else {
                                            List<String> stringList = new ArrayList<>();
                                            stringList.add(connectionList.get(inputIndex - 1).source);
                                            stringList.add(connectionList.get(inputIndex - 1).destination);
                                            connectedCities.add(stringList);
                                        }
                                        if (connectionList.get(inputIndex - 1).pathway2.tracks == 1) {
                                            score += 1;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 2) {
                                            score += 2;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 3) {
                                            score += 4;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 4) {
                                            score += 7;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 5) {
                                            score += 10;
                                        } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 6) {
                                            score += 15;
                                        }
                                        System.out.println("Player " + name + ", your track has been built.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                    } else {
                                        System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                                        for (int i = 0; i < redCards.size(); ) {
                                            cards.add(redCards.get(0));
                                            redCards.remove(0);
                                        }
                                        for (int i = 0; i < orangeCards.size(); ) {
                                            cards.add(orangeCards.get(0));
                                            orangeCards.remove(0);
                                        }
                                        for (int i = 0; i < yellowCards.size(); ) {
                                            cards.add(yellowCards.get(0));
                                            yellowCards.remove(0);
                                        }
                                        for (int i = 0; i < greenCards.size(); ) {
                                            cards.add(greenCards.get(0));
                                            greenCards.remove(0);
                                        }
                                        for (int i = 0; i < blueCards.size(); ) {
                                            cards.add(blueCards.get(0));
                                            blueCards.remove(0);
                                        }
                                        for (int i = 0; i < pinkCards.size(); ) {
                                            cards.add(pinkCards.get(0));
                                            pinkCards.remove(0);
                                        }
                                        for (int i = 0; i < blackCards.size(); ) {
                                            cards.add(blackCards.get(0));
                                            blackCards.remove(0);
                                        }
                                        for (int i = 0; i < whiteCards.size(); ) {
                                            cards.add(whiteCards.get(0));
                                            whiteCards.remove(0);
                                        }
                                        for (int i = 0; i < locoCards.size(); ) {
                                            cards.add(locoCards.get(0));
                                            locoCards.remove(0);
                                        }
                                        playTurn(board, ticketList, connectionList);
                                    }
                                } else {
                                    System.out.println("Player " + name + ", you do not have enough of this type of card to build on this pathway.");
                                    for (int i = 0; i < redCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        redCards.remove(0);
                                    }
                                    for (int i = 0; i < orangeCards.size(); ) {
                                        cards.add(orangeCards.get(0));
                                        orangeCards.remove(0);
                                    }
                                    for (int i = 0; i < yellowCards.size(); ) {
                                        cards.add(yellowCards.get(0));
                                        yellowCards.remove(0);
                                    }
                                    for (int i = 0; i < greenCards.size(); ) {
                                        cards.add(greenCards.get(0));
                                        greenCards.remove(0);
                                    }
                                    for (int i = 0; i < blueCards.size(); ) {
                                        cards.add(blueCards.get(0));
                                        blueCards.remove(0);
                                    }
                                    for (int i = 0; i < pinkCards.size(); ) {
                                        cards.add(pinkCards.get(0));
                                        pinkCards.remove(0);
                                    }
                                    for (int i = 0; i < blackCards.size(); ) {
                                        cards.add(blackCards.get(0));
                                        blackCards.remove(0);
                                    }
                                    for (int i = 0; i < whiteCards.size(); ) {
                                        cards.add(whiteCards.get(0));
                                        whiteCards.remove(0);
                                    }
                                    for (int i = 0; i < locoCards.size(); ) {
                                        cards.add(redCards.get(0));
                                        locoCards.remove(0);
                                    }
                                    playTurn(board, ticketList, connectionList);
                                }
                            }

                        } else {
                            System.out.println("Player " + name + ", you do not have enough cards to build on this pathway.");
                            for (int i = 0; i < redCards.size(); ) {
                                cards.add(redCards.get(0));
                                redCards.remove(0);
                            }
                            for (int i = 0; i < orangeCards.size(); ) {
                                cards.add(orangeCards.get(0));
                                orangeCards.remove(0);
                            }
                            for (int i = 0; i < yellowCards.size(); ) {
                                cards.add(yellowCards.get(0));
                                yellowCards.remove(0);
                            }
                            for (int i = 0; i < greenCards.size(); ) {
                                cards.add(greenCards.get(0));
                                greenCards.remove(0);
                            }
                            for (int i = 0; i < blueCards.size(); ) {
                                cards.add(blueCards.get(0));
                                blueCards.remove(0);
                            }
                            for (int i = 0; i < pinkCards.size(); ) {
                                cards.add(pinkCards.get(0));
                                pinkCards.remove(0);
                            }
                            for (int i = 0; i < blackCards.size(); ) {
                                cards.add(blackCards.get(0));
                                blackCards.remove(0);
                            }
                            for (int i = 0; i < whiteCards.size(); ) {
                                cards.add(whiteCards.get(0));
                                whiteCards.remove(0);
                            }
                            for (int i = 0; i < locoCards.size(); ) {
                                cards.add(redCards.get(0));
                                locoCards.remove(0);
                            }
                            playTurn(board, ticketList, connectionList);
                        }

                    } else if (usableCards.size() >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                        if (tracks >= connectionList.get(inputIndex - 1).pathway2.tracks) {
                            while (usableCards.size() > connectionList.get(inputIndex - 1).pathway2.tracks) {
                                cards.add(usableCards.get(0));
                                usableCards.remove(0);
                            }
                            connectionList.get(inputIndex - 1).pathway2.open = false;
                            connectionList.get(inputIndex - 1).pathway2.player = this;
                            tracks -= connectionList.get(inputIndex - 1).pathway2.tracks;
                            boolean connectionFound = false;
                            if (connectedCities.size() > 0) {
                                for (int i = 0; i < connectedCities.size(); i++) {
                                    if (connectionFound == false) {
                                        for (int j = 0; j < connectedCities.get(i).size(); j++) {
                                            if ((connectionList.get(inputIndex - 1).source == connectedCities.get(i).get(j) || connectionList.get(inputIndex - 1).destination == connectedCities.get(i).get(j)) && connectionFound == false) {
                                                connectedCities.get(i).add(connectionList.get(inputIndex - 1).source);
                                                connectedCities.get(i).add(connectionList.get(inputIndex - 1).destination);
                                                connectionFound = true;
                                            }
                                        }
                                    }
                                }
                                if (connectionFound == false) {
                                    List<String> stringList = new ArrayList<>();
                                    stringList.add(connectionList.get(inputIndex - 1).source);
                                    stringList.add(connectionList.get(inputIndex - 1).destination);
                                    connectedCities.add(stringList);

                                }
                            } else {
                                List<String> stringList = new ArrayList<>();
                                stringList.add(connectionList.get(inputIndex - 1).source);
                                stringList.add(connectionList.get(inputIndex - 1).destination);
                                connectedCities.add(stringList);
                            }
                            if (connectionList.get(inputIndex - 1).pathway2.tracks == 1) {
                                score += 1;
                            } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 2) {
                                score += 2;
                            } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 3) {
                                score += 4;
                            } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 4) {
                                score += 7;
                            } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 5) {
                                score += 10;
                            } else if (connectionList.get(inputIndex - 1).pathway2.tracks == 6) {
                                score += 15;
                            }
                            System.out.println("Player " + name + ", your track has been built.");
                        } else {
                            System.out.println("Player " + name + ", you do not have enough tracks to build on this pathway.");
                            int usableCardsSize = usableCards.size();
                            for (int i = 0; i < usableCardsSize; i++) {
                                cards.add(usableCards.get(0));
                                usableCards.remove(0);
                            }
                            playTurn(board, ticketList, connectionList);
                        }
                    } else {
                        System.out.println("Player " + name + ", you do not have enough cards to build on this pathway.");
                        int usableCardsSize = usableCards.size();
                        for (int i = 0; i < usableCardsSize; i++) {
                            cards.add(usableCards.get(0));
                            usableCards.remove(0);
                        }
                        playTurn(board, ticketList, connectionList);
                    }
                }
            } else {
                System.out.println("Player " + name + ", that connection is not available.");
                playTurn(board, ticketList, connectionList);
            }
        }

        for (int j = 0; j < connectedCities.size(); j++) {
            int connectedCitiesSize = connectedCities.get(j).size();
            for (int k = 0; k < connectedCitiesSize; k++) {
                for (int l = 0; l < connectedCities.size(); l++) {
                    if (l != j) {
                        for (int m = 0; m < connectedCities.size(); m++) {
                            if (connectedCities.get(j).get(k) == connectedCities.get(l).get(m)) {
                                for (int i = 0; i < connectedCities.get(l).size(); i++) {
                                    connectedCities.get(j).add(connectedCities.get(l).get(i));
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < tickets.size(); i++) {
            for (int j = 0; j < connectedCities.size(); j++) {
                for (int k = 0; k < connectedCities.get(j).size(); k++) {
                    if (tickets.get(i).source == connectedCities.get(j).get(k)) {
                        for (int l = 0; l < connectedCities.get(j).size(); l++) {
                            if (tickets.get(i).destination == connectedCities.get(j).get(l)) {
                                score += tickets.get(i).value;
                                tickets.remove(i);
                            }
                        }
                    }
                }
            }
        }

        print();
        System.out.println("Player " + name + ", type 1 to end your turn.");
        boolean isValidInput = false;
        int inputIndex = -1;
        while (!isValidInput) {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = reader.readLine();
                inputIndex = Integer.parseInt(input);
                if (inputIndex == 1) {
                    isValidInput = true;
                }
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < 23; i++) {
            System.out.println();
        }
    }

    private TakeCard getTakeCard(Board board) {
        boolean isValidInput = false;
        int inputIndex = -1;
        while (!isValidInput) {

            System.out.println("Player " + name + ", pick a card: ");
            for (int i = 0; i < 5; i++) {
                System.out.println(i + 1 + " = " + board.fiveOpenCards.get(i));
            }
            System.out.println("6 = draw");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = reader.readLine();
                inputIndex = Integer.parseInt(input);
                if (inputIndex < 7 && inputIndex >= 0) {
                    isValidInput = true;
                }
            } catch (Exception e) {
            }
        }
        return TakeCard.getTakeCard(inputIndex);
    }

    private PlayType getPlayType() {

        boolean isValidInput = false;
        int inputIndex = -1;
        while (!isValidInput) {

            System.out.println("Player " + name + ", pick an action: ");
            System.out.println("1 = Draw Cards");
            System.out.println("2 = Build Tracks");
            System.out.println("3 = Draw Tickets");

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = reader.readLine();
                inputIndex = Integer.parseInt(input);
                if (inputIndex < 4 && inputIndex > 0) {
                    isValidInput = true;
                }
            } catch (Exception e) {
            }
        }
        return PlayType.getPlayType(inputIndex);
    }
}