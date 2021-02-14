import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Board {

    List<Player> playerList;

    Connection cn1 = Connection.buildConnection("Vancouver", "Seattle", true, 1, TrackColor.grey, TrackColor.grey);
    Connection cn2 = Connection.buildConnection("Vancouver", "Calgary", false, 3, TrackColor.grey, null);
    Connection cn3 = Connection.buildConnection("Seattle", "Portland", true, 1, TrackColor.grey, TrackColor.grey);
    Connection cn4 = Connection.buildConnection("Seattle", "Helena", false, 6, TrackColor.yellow, null);
    Connection cn5 = Connection.buildConnection("Seattle", "Calgary", false, 4, TrackColor.grey, null);
    Connection cn6 = Connection.buildConnection("Portland", "San Francisco", true, 5, TrackColor.green, TrackColor.pink);
    Connection cn7 = Connection.buildConnection("Portland", "Salt Lake City", false, 6, TrackColor.blue, null);
    Connection cn8 = Connection.buildConnection("San Francisco", "Los Angeles", true, 3, TrackColor.yellow, TrackColor.pink);
    Connection cn9 = Connection.buildConnection("San Francisco", "Salt Lake City", true, 5, TrackColor.orange, TrackColor.white);
    Connection cn10 = Connection.buildConnection("Los Angeles", "Las Vegas", false, 2, TrackColor.orange, null);
    Connection cn11 = Connection.buildConnection("Los Angeles", "Phoenix", false, 3, TrackColor.grey, null);
    Connection cn12 = Connection.buildConnection("Los Angeles", "El Paso", false, 6, TrackColor.black, null);
    Connection cn13 = Connection.buildConnection("Las Vegas", "Salt Lake City", false, 3, TrackColor.orange, null);
    Connection cn14 = Connection.buildConnection("El Paso", "Santa Fe", false, 2, TrackColor.grey, null);
    Connection cn15 = Connection.buildConnection("El Paso", "Oklahoma City", false, 5, TrackColor.yellow, null);
    Connection cn16 = Connection.buildConnection("El Paso", "Dallas", false, 4, TrackColor.red, null);
    Connection cn17 = Connection.buildConnection("El Paso", "Houston", false, 6, TrackColor.green, null);
    Connection cn18 = Connection.buildConnection("Calgary", "Winnipeg", false, 6, TrackColor.white, null);
    Connection cn19 = Connection.buildConnection("Calgary", "Helena", false, 4, TrackColor.grey, null);
    Connection cn20 = Connection.buildConnection("Helena", "Winnipeg", false, 4, TrackColor.blue, null);
    Connection cn21 = Connection.buildConnection("Helena", "Duluth", false, 6, TrackColor.orange, null);
    Connection cn22 = Connection.buildConnection("Helena", "Omaha", false, 5, TrackColor.red, null);
    Connection cn23 = Connection.buildConnection("Helena", "Denver", false, 4, TrackColor.green, null);
    Connection cn24 = Connection.buildConnection("Helena", "Salt Lake City", false, 3, TrackColor.pink, null);
    Connection cn25 = Connection.buildConnection("Salt Lake City", "Denver", true, 3, TrackColor.red, TrackColor.yellow);
    Connection cn26 = Connection.buildConnection("Phoenix", "Denver", false, 5, TrackColor.white, null);
    Connection cn27 = Connection.buildConnection("Phoenix", "Santa Fe", false, 3, TrackColor.grey, null);
    Connection cn28 = Connection.buildConnection("Phoenix", "El Paso", false, 3, TrackColor.grey, null);
    Connection cn29 = Connection.buildConnection("Winnipeg", "Saint St. Marie", false, 6, TrackColor.grey, null);
    Connection cn30 = Connection.buildConnection("Winnipeg", "Duluth", false, 4, TrackColor.black, null);
    Connection cn31 = Connection.buildConnection("Denver", "Santa Fe", false, 2, TrackColor.grey, null);
    Connection cn32 = Connection.buildConnection("Denver", "Oklahoma City", false, 4, TrackColor.red, null);
    Connection cn33 = Connection.buildConnection("Denver", "Kansas City", true, 4, TrackColor.black, TrackColor.orange);
    Connection cn34 = Connection.buildConnection("Denver", "Omaha", false, 4, TrackColor.pink, null);
    Connection cn35 = Connection.buildConnection("Santa Fe", "Oklahoma City", false, 3, TrackColor.blue, null);
    Connection cn36 = Connection.buildConnection("Duluth", " Saint St. Marie", false, 3, TrackColor.grey, null);
    Connection cn37 = Connection.buildConnection("Duluth", "Toronto", false, 6, TrackColor.pink, null);
    Connection cn38 = Connection.buildConnection("Duluth", "Chicago", false, 3, TrackColor.red, null);
    Connection cn39 = Connection.buildConnection("Duluth", "Omaha", true, 2, TrackColor.grey, TrackColor.grey);
    Connection cn40 = Connection.buildConnection("Omaha", "Chicago", false, 4, TrackColor.blue, null);
    Connection cn41 = Connection.buildConnection("Omaha", "Kansas City", true, 1, TrackColor.grey, TrackColor.grey);
    Connection cn42 = Connection.buildConnection("Kansas City", "Saint Louis", true, 2, TrackColor.blue, TrackColor.pink);
    Connection cn43 = Connection.buildConnection("Kansas City", "Oklahoma City", true, 2, TrackColor.grey, TrackColor.grey);
    Connection cn44 = Connection.buildConnection("Oklahoma City", "Little Rock", false, 2, TrackColor.grey, null);
    Connection cn45 = Connection.buildConnection("Oklahoma City", "Dallas", true, 2, TrackColor.grey, TrackColor.grey);
    Connection cn46 = Connection.buildConnection("Dallas", "Little Rock", false, 2, TrackColor.grey, null);
    Connection cn47 = Connection.buildConnection("Dallas", "Houston", true, 1, TrackColor.grey, TrackColor.grey);
    Connection cn48 = Connection.buildConnection("Houston", "New Orleans", false, 2, TrackColor.grey, TrackColor.grey);
    Connection cn49 = Connection.buildConnection("Saint St. Marie", "Montreal", false, 5, TrackColor.black, null);
    Connection cn50 = Connection.buildConnection("Saint St. Marie", "Toronto", false, 2, TrackColor.grey, null);
    Connection cn51 = Connection.buildConnection("Toronto", "Chicago", false, 4, TrackColor.white, null);
    Connection cn52 = Connection.buildConnection("Toronto", "Montreal", false, 3, TrackColor.grey, null);
    Connection cn53 = Connection.buildConnection("Toronto", "Pittsburgh", false, 2, TrackColor.grey, null);
    Connection cn54 = Connection.buildConnection("Saint Louis", "Chicago", true, 2, TrackColor.green, TrackColor.white);
    Connection cn55 = Connection.buildConnection("Chicago", "Pittsburgh", true, 3, TrackColor.orange, TrackColor.black);
    Connection cn56 = Connection.buildConnection("Saint Louis", "Little Rock", false, 2, TrackColor.grey, null);
    Connection cn57 = Connection.buildConnection("Saint Louis", "Nashville", false, 2, TrackColor.grey, null);
    Connection cn58 = Connection.buildConnection("Saint Louis", "Pittsburgh", false, 5, TrackColor.green, null);
    Connection cn59 = Connection.buildConnection("Little Rock", "New Orleans", false, 3, TrackColor.green, null);
    Connection cn60 = Connection.buildConnection("Little Rock", "Nashville", false, 3, TrackColor.white, null);
    Connection cn61 = Connection.buildConnection("New Orleans", "Atlanta", true, 4, TrackColor.yellow, TrackColor.orange);
    Connection cn62 = Connection.buildConnection("Nashville", "Pittsburgh", false, 4, TrackColor.yellow, null);
    Connection cn63 = Connection.buildConnection("Nashville", "Raleigh", false, 3, TrackColor.black, null);
    Connection cn64 = Connection.buildConnection("Nashville", "Atlanta", false, 1, TrackColor.grey, null);
    Connection cn65 = Connection.buildConnection("Pittsburgh", "New York", true, 2, TrackColor.white, TrackColor.green);
    Connection cn66 = Connection.buildConnection("Pittsburgh", "Washington", false, 2, TrackColor.grey, null);
    Connection cn67 = Connection.buildConnection("Pittsburgh", "Raleigh", false, 2, TrackColor.grey, null);
    Connection cn68 = Connection.buildConnection("Raleigh", "Atlanta", true, 2, TrackColor.grey, TrackColor.grey);
    Connection cn69 = Connection.buildConnection("Raleigh", "Washington", true, 2, TrackColor.grey, TrackColor.grey);
    Connection cn70 = Connection.buildConnection("Raleigh", "Charleston", false, 2, TrackColor.grey, null);
    Connection cn71 = Connection.buildConnection("Atlanta", "Charleston", false, 2, TrackColor.grey, null);
    Connection cn72 = Connection.buildConnection("Atlanta", "Miami", false, 5, TrackColor.blue, null);
    Connection cn73 = Connection.buildConnection("Miami", "New Orleans", false, 6, TrackColor.red, null);
    Connection cn74 = Connection.buildConnection("Miami", "Charleston", false, 4, TrackColor.pink, null);
    Connection cn75 = Connection.buildConnection("Washington", "New York", true, 2, TrackColor.orange, TrackColor.black);
    Connection cn76 = Connection.buildConnection("New York", "Montreal", false, 3, TrackColor.blue, null);
    Connection cn77 = Connection.buildConnection("New York", "Boston", true, 2, TrackColor.yellow, TrackColor.red);
    Connection cn78 = Connection.buildConnection("Boston", "Montreal", true, 2, TrackColor.grey, TrackColor.grey);


    private List<Connection> connectionList = new ArrayList<>(Arrays.asList(cn1, cn2, cn3, cn4, cn5, cn6, cn7, cn8, cn9, cn10, cn11, cn12, cn13, cn14, cn15, cn16, cn17, cn18, cn19, cn20, cn21, cn22, cn23, cn24, cn25, cn26, cn27, cn28, cn29, cn30, cn31, cn32, cn33, cn34, cn35, cn36, cn37, cn38, cn39, cn40, cn41, cn42, cn43, cn44, cn45, cn46, cn47, cn48, cn49, cn50, cn51, cn52, cn53, cn54, cn55, cn56, cn57, cn58, cn59, cn60, cn61, cn62, cn63, cn64, cn65, cn66, cn67, cn68, cn69, cn70, cn71, cn72, cn73, cn74, cn75, cn76, cn77, cn78));

    Ticket t1 = Ticket.buildTicket("Boston", "Miami", 12);
    Ticket t2 = Ticket.buildTicket("Calgary", "Phoenix", 13);
    Ticket t3 = Ticket.buildTicket("Calgary", "Salt Lake City", 7);
    Ticket t4 = Ticket.buildTicket("Chicago", "New Orleans", 7);
    Ticket t5 = Ticket.buildTicket("Chicago", "Santa Fe", 9);
    Ticket t6 = Ticket.buildTicket("Dallas", "New York", 11);
    Ticket t7 = Ticket.buildTicket("Denver", "El Paso", 4);
    Ticket t8 = Ticket.buildTicket("Denver", "Pittsburgh", 11);
    Ticket t9 = Ticket.buildTicket("Duluth", "El Paso", 10);
    Ticket t10 = Ticket.buildTicket("Duluth", "Houston", 8);
    Ticket t11 = Ticket.buildTicket("Helena", "Los Angeles", 8);
    Ticket t12 = Ticket.buildTicket("Kansas City", "Houston", 5);
    Ticket t13 = Ticket.buildTicket("Los Angeles", "Chicago", 16);
    Ticket t14 = Ticket.buildTicket("Los Angeles", "Miami", 20);
    Ticket t15 = Ticket.buildTicket("Los Angeles", "New York", 21);
    Ticket t16 = Ticket.buildTicket("Montreal", "Atlanta", 9);
    Ticket t17 = Ticket.buildTicket("Montreal", "New Orleans", 13);
    Ticket t18 = Ticket.buildTicket("New York", "Atlanta", 6);
    Ticket t19 = Ticket.buildTicket("Portland", "Nashville", 17);
    Ticket t20 = Ticket.buildTicket("Portland", "Phoenix", 11);
    Ticket t21 = Ticket.buildTicket("San Francisco", "Atlanta", 17);
    Ticket t22 = Ticket.buildTicket("Saint St. Marie", "Nashville", 8);
    Ticket t23 = Ticket.buildTicket("Saint St. Marie", "Oklahoma City", 9);
    Ticket t24 = Ticket.buildTicket("Seattle", "Los Angeles", 9);
    Ticket t25 = Ticket.buildTicket("Seattle", "New York", 22);
    Ticket t26 = Ticket.buildTicket("Toronto", "Miami", 10);
    Ticket t27 = Ticket.buildTicket("Vancouver", "Montreal", 20);
    Ticket t28 = Ticket.buildTicket("Vancouver", "Santa Fe", 13);
    Ticket t29 = Ticket.buildTicket("Winnipeg", "Houston", 12);
    Ticket t30 = Ticket.buildTicket("Winnipeg", "Little Rock", 11);

    private List<Ticket> ticketList = new ArrayList<>(Arrays.asList(t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30));

    Card cd1 = new Card(CardColor.red);
    Card cd2 = new Card(CardColor.red);
    Card cd3 = new Card(CardColor.red);
    Card cd4 = new Card(CardColor.red);
    Card cd5 = new Card(CardColor.red);
    Card cd6 = new Card(CardColor.red);
    Card cd7 = new Card(CardColor.red);
    Card cd8 = new Card(CardColor.red);
    Card cd9 = new Card(CardColor.red);
    Card cd10 = new Card(CardColor.red);
    Card cd11 = new Card(CardColor.red);
    Card cd12 = new Card(CardColor.red);
    Card cd13 = new Card(CardColor.orange);
    Card cd14 = new Card(CardColor.orange);
    Card cd15 = new Card(CardColor.orange);
    Card cd16 = new Card(CardColor.orange);
    Card cd17 = new Card(CardColor.orange);
    Card cd18 = new Card(CardColor.orange);
    Card cd19 = new Card(CardColor.orange);
    Card cd20 = new Card(CardColor.orange);
    Card cd21 = new Card(CardColor.orange);
    Card cd22 = new Card(CardColor.orange);
    Card cd23 = new Card(CardColor.orange);
    Card cd24 = new Card(CardColor.orange);
    Card cd25 = new Card(CardColor.yellow);
    Card cd26 = new Card(CardColor.yellow);
    Card cd27 = new Card(CardColor.yellow);
    Card cd28 = new Card(CardColor.yellow);
    Card cd29 = new Card(CardColor.yellow);
    Card cd30 = new Card(CardColor.yellow);
    Card cd31 = new Card(CardColor.yellow);
    Card cd32 = new Card(CardColor.yellow);
    Card cd33 = new Card(CardColor.yellow);
    Card cd34 = new Card(CardColor.yellow);
    Card cd35 = new Card(CardColor.yellow);
    Card cd36 = new Card(CardColor.yellow);
    Card cd37 = new Card(CardColor.green);
    Card cd38 = new Card(CardColor.green);
    Card cd39 = new Card(CardColor.green);
    Card cd40 = new Card(CardColor.green);
    Card cd41 = new Card(CardColor.green);
    Card cd42 = new Card(CardColor.green);
    Card cd43 = new Card(CardColor.green);
    Card cd44 = new Card(CardColor.green);
    Card cd45 = new Card(CardColor.green);
    Card cd46 = new Card(CardColor.green);
    Card cd47 = new Card(CardColor.green);
    Card cd48 = new Card(CardColor.green);
    Card cd49 = new Card(CardColor.blue);
    Card cd50 = new Card(CardColor.blue);
    Card cd51 = new Card(CardColor.blue);
    Card cd52 = new Card(CardColor.blue);
    Card cd53 = new Card(CardColor.blue);
    Card cd54 = new Card(CardColor.blue);
    Card cd55 = new Card(CardColor.blue);
    Card cd56 = new Card(CardColor.blue);
    Card cd57 = new Card(CardColor.blue);
    Card cd58 = new Card(CardColor.blue);
    Card cd59 = new Card(CardColor.blue);
    Card cd60 = new Card(CardColor.blue);
    Card cd61 = new Card(CardColor.pink);
    Card cd62 = new Card(CardColor.pink);
    Card cd63 = new Card(CardColor.pink);
    Card cd64 = new Card(CardColor.pink);
    Card cd65 = new Card(CardColor.pink);
    Card cd66 = new Card(CardColor.pink);
    Card cd67 = new Card(CardColor.pink);
    Card cd68 = new Card(CardColor.pink);
    Card cd69 = new Card(CardColor.pink);
    Card cd70 = new Card(CardColor.pink);
    Card cd71 = new Card(CardColor.pink);
    Card cd72 = new Card(CardColor.pink);
    Card cd73 = new Card(CardColor.black);
    Card cd74 = new Card(CardColor.black);
    Card cd75 = new Card(CardColor.black);
    Card cd76 = new Card(CardColor.black);
    Card cd77 = new Card(CardColor.black);
    Card cd78 = new Card(CardColor.black);
    Card cd79 = new Card(CardColor.black);
    Card cd80 = new Card(CardColor.black);
    Card cd81 = new Card(CardColor.black);
    Card cd82 = new Card(CardColor.black);
    Card cd83 = new Card(CardColor.black);
    Card cd84 = new Card(CardColor.black);
    Card cd85 = new Card(CardColor.white);
    Card cd86 = new Card(CardColor.white);
    Card cd87 = new Card(CardColor.white);
    Card cd88 = new Card(CardColor.white);
    Card cd89 = new Card(CardColor.white);
    Card cd90 = new Card(CardColor.white);
    Card cd91 = new Card(CardColor.white);
    Card cd92 = new Card(CardColor.white);
    Card cd93 = new Card(CardColor.white);
    Card cd94 = new Card(CardColor.white);
    Card cd95 = new Card(CardColor.white);
    Card cd96 = new Card(CardColor.white);
    Card cd97 = new Card(CardColor.locomotive);
    Card cd98 = new Card(CardColor.locomotive);
    Card cd99 = new Card(CardColor.locomotive);
    Card cd100 = new Card(CardColor.locomotive);
    Card cd101 = new Card(CardColor.locomotive);
    Card cd102 = new Card(CardColor.locomotive);
    Card cd103 = new Card(CardColor.locomotive);
    Card cd104 = new Card(CardColor.locomotive);
    Card cd105 = new Card(CardColor.locomotive);
    Card cd106 = new Card(CardColor.locomotive);
    Card cd107 = new Card(CardColor.locomotive);
    Card cd108 = new Card(CardColor.locomotive);
    Card cd109 = new Card(CardColor.locomotive);
    Card cd110 = new Card(CardColor.locomotive);

    private List<Card> cardList = new ArrayList<>(Arrays.asList(cd1, cd2, cd3, cd4, cd5, cd6, cd7, cd8, cd9, cd10, cd11, cd12, cd13, cd14, cd15, cd16, cd17, cd18, cd19, cd20, cd21, cd22, cd23, cd24, cd25, cd26, cd27, cd28, cd29, cd30, cd31, cd32, cd33, cd34, cd35, cd36, cd37, cd38, cd39, cd40, cd41, cd42, cd43, cd44, cd45, cd46, cd47, cd48, cd49, cd50, cd51, cd52, cd53, cd54, cd55, cd56, cd57, cd58, cd59, cd60, cd61, cd62, cd63, cd64, cd65, cd66, cd67, cd68, cd69, cd70, cd71, cd72, cd73, cd74, cd75, cd76, cd77, cd78, cd79, cd80, cd81, cd82, cd83, cd84, cd85, cd86, cd87, cd88, cd89, cd90, cd91, cd92, cd93, cd94, cd95, cd96, cd97, cd98, cd99, cd100, cd101, cd102, cd103, cd104, cd105, cd106, cd107, cd108, cd109, cd110));

    List<Card> fiveOpenCards = new ArrayList<>();

    public Board(List<Player> inputPlayers) {

        this.playerList = inputPlayers;

    }

    public void print() {
        System.out.println("Players:");
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println(playerList.get(i));
        }
        System.out.println();
        System.out.println("Connections:");
        for (int i = 0; i < connectionList.size(); i++) {
            System.out.println(connectionList.get(i));
        }
        System.out.println();
        System.out.println("Tickets:");
        for (int i = 0; i < ticketList.size(); i++) {
            System.out.println(ticketList.get(i));
        }
        System.out.println();
        System.out.println("Open Cards:");
        for (int i = 0; i < fiveOpenCards.size(); i++) {
            System.out.println(fiveOpenCards.get(i));
        }
        System.out.println();
        System.out.println("Card Pile:");
        for (int i = 0; i < cardList.size(); i++) {
            System.out.println(cardList.get(i));
        }
    }

    public void shuffleTickets() {
        Collections.shuffle(ticketList);
    }

    public void shuffleCards() {
        Collections.shuffle(cardList);
    }

    public void distributeTickets() {

        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).firstTurnReturnTickets(ticketList);
            for (int j = 0; j < 23; j++) {
                System.out.println();
            }
        }
    }

    public void distributeCards() {

        for (int i = 0; i < playerList.size(); i++) {
            playerList.get(i).addCards(cardList);
        }
    }

    public void openFiveCards() {
        int locos = 0;
        boolean threeLocos = true;
        while (threeLocos == true) {
            for (int i = 0; i < 5; i++) {
                fiveOpenCards.add(cardList.get(i));
                if (cardList.get(i).cardColor == CardColor.locomotive) {
                    locos += 1;
                }
            }
            if (locos < 3) {
                threeLocos = false;
                for (int i = 0; i < 5; i++) {
                    cardList.remove(0);
                }
            } else {
                for (int i = 0; i < 5; i++) {
                    cardList.add(fiveOpenCards.get(0));
                    fiveOpenCards.remove(0);
                    shuffleCards();
                }
            }
        }
    }

    public void playYourTurn() {
        boolean isGamePlaying = true;
        int i = 0;
        List<Integer> scores = new ArrayList<>();
        while (isGamePlaying == true) {
            if (playerList.get(i).tracks <= 2) {
                playerList.get(i).playTurn(this, ticketList, connectionList);
                System.out.println(playerList.get(i));
                for (int j = 0; j < playerList.size(); j++) {
                    for (int k = 0; k < playerList.get(j).tickets.size(); k++) {
                        playerList.get(j).score -= playerList.get(j).tickets.get(k).value;
                    }
                    System.out.println("Player " + playerList.get(j).name + "'s score: " + playerList.get(j).score);
                    scores.add(playerList.get(j).score);
                }
                int highestScore = Collections.max(scores);
                boolean winningPlayerFound = false;
                for (int l = 0; l < playerList.size(); l++) {
                    if (playerList.get(l).score == highestScore && winningPlayerFound == false) {
                        System.out.println("Player " + playerList.get(l).name + " wins!");
                        winningPlayerFound = true;
                    }
                }
                isGamePlaying = false;
            } else {
                playerList.get(i).playTurn(this, ticketList, connectionList);
                if (i < playerList.size() - 1) {
                    i++;
                } else {
                    i = 0;
                }
            }
        }
    }

    public void checkOpenCards() {
        System.out.println("Open cards:");
        for (int i = 0; i < fiveOpenCards.size(); i++) {
            System.out.println(fiveOpenCards.get(i));
        }
        System.out.println();
    }

    public Card getCard(TakeCard card) {

        int cardIndex = card.ordinal();

        if (cardIndex <= 4) {
            Card wantedCard = fiveOpenCards.get(cardIndex);
            fiveOpenCards.remove(cardIndex);
            fiveOpenCards.add(cardList.get(0));
            cardList.remove(0);
            return wantedCard;
        } else {
            Card wantedCard = cardList.get(0);
            cardList.remove(0);
            return wantedCard;
        }
    }

    public boolean isTakeCardValid(TakeCard takeCard, boolean isFirstTurn) {
        if (isFirstTurn == false && takeCard.ordinal() < 5 && fiveOpenCards.get(takeCard.ordinal()).isLocomotive() == true) {
            return false;
        } else {
            return true;
        }
    }

    public void start() {
        shuffleTickets();
        shuffleCards();
        distributeTickets();
        distributeCards();
        openFiveCards();
        playYourTurn();
    }
}






