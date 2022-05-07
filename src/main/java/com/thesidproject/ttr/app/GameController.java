package com.thesidproject.ttr.app;

import com.thesidproject.Board;
import com.thesidproject.Player;
import com.thesidproject.PlayerColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Controller
public class GameController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    GameManager gameManager;


    @PostMapping("/game")
    public String createGame(String playerName) {


        Board board = gameManager.createBoard(playerName);
        if (board != null) {
            boardcastBoard(board);
//            return boardId;
            return "";
        } else {
            return "Error message";
        }
    }

    private void boardcastBoard(Board board) {
//        this.simpMessagingTemplate.convertAndSend("/topic/" + board.getBoardId(), board.toString());
    }

    @PutMapping("/game/player")
    public String joinGame(String boardId, String playerName) {
        String playerId = gameManager.joinBoard(boardId, playerName);
        if (playerId != null) {
            Board board = gameManager.getBoard(boardId);
            boardcastBoard(board);
            return playerId;
        } else {
            return "Error message";
        }
    }

    @PutMapping("/game/start")
    public String startGame(String boardId, String playerId) {
        Board board = gameManager.startGame(boardId, playerId);
        if (board != null) {
            boardcastBoard(board);
            return "";
        } else {
            return "Error message";
        }
    }

    @PutMapping("/game/player/pick-play")
    public Board pickPlay(String boardId, String playerId, String playType) {
        return null;
    }

    @PutMapping("/game/player/draw-tickets")
    public Board drawTickets(String boardId, String playerId, String playType) {
        return null;
    }

    @PutMapping("/game/player/return-tickets")
    public Board returnTickets(String boardId, String playerId, List<String> ticketIds) {
        return null;
    }

    @PutMapping("/game/player/draw-card")
    public Board drawCard(String boardId, String playerId, int cardPosition) {
        return null;
    }

    @PutMapping("/game/player/build-track")
    public Board buildConnection(String boardId, String playerId, String connectionId, List<String> cardsToUse) {
        return null;
    }

}

