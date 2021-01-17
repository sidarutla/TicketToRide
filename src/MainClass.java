import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

    public static void main(String[] args) throws Exception {

        Player rama = new Player("Rama", PlayerColor.red);
        Player sid = new Player("Sid",PlayerColor.green);
        Player keerthi = new Player("Keerthi",PlayerColor.black);
        List<Player> playerArray = Arrays.asList(rama, sid, keerthi);
    }
}
