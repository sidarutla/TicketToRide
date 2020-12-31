import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {


    public static void main(String[] args) {

        Player rama = new Player("Rama", PlayerColor.red);
        Player sid = new Player("Sid",PlayerColor.green);
        Player keerthi = new Player("Keerthi",PlayerColor.black);
        Player harshu = new Player("Harshu",PlayerColor.blue);
        List<Player> playerArray = Arrays.asList(rama, sid, keerthi, harshu);
        Board board = new Board(playerArray);
        board.start();
    }
}
