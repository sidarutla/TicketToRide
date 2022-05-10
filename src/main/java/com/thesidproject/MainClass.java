package com.thesidproject;

import com.thesidproject.Board;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

    public static Board getBoard() {
        Player rama = new Player("Mommy the Gr");
        Player sid = new Player("Sid");
        Player keerthi = new Player("Keerthi");
        Player harshu = new Player("Mr. Badoongyface");
        List<Player> playerArray = Arrays.asList(rama, sid, keerthi, harshu);
        Board board = new Board(sid, "Sid's Board");
        board.shuffleCards();
        board.shuffleTickets();
        board.distributeCards();
        board.openFiveCards();
        return board;
    }
}
