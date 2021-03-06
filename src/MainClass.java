import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

    public static Board getBoard() {
        Player rama = new Player("Mommy the Gr", PlayerColor.yellow);
        Player sid = new Player("Sid", PlayerColor.green);
        Player keerthi = new Player("Keerthi", PlayerColor.black);
        Player harshu = new Player("Mr. Badoongyface", PlayerColor.blue);
        List<Player> playerArray = Arrays.asList(rama, sid, keerthi, harshu);
        Board board = new Board(playerArray);
        board.shuffleCards();
        board.shuffleTickets();
        board.distributeCards();
        board.distributeTickets();
        board.openFiveCards();
        return board;
    }
}
