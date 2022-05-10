package com.thesidproject.ttr.app;

import com.thesidproject.Board;
import com.thesidproject.PlayType;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:3001", "http://192.168.86.105:3001"}, maxAge = 3600)
@RestController
@Controller
public class BoardController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    BoardManager boardManager;

    private ResponseEntity<JSONObject> returnErrorResponse(String errorMessage) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("error", errorMessage);
        return ResponseEntity.badRequest().body(jsonObject);
    }

    private void boardcastBoard(Board board) {
        this.simpMessagingTemplate.convertAndSend("/topic/" + board.getBoardID(), board);
    }

    private void boardcastBoardState(Board board) {
        this.simpMessagingTemplate.convertAndSend("/topic/boards", board);
    }


    @PostMapping("/boards")
    public ResponseEntity<?> createBoard(@RequestBody CrateBoardInput input) {
        Board board = boardManager.createBoard(input.boardName, input.playerID);
            if (board != null) {
            boardcastBoard(board);
            boardcastBoardState(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Error creating player");
        }
    }

    @PostMapping("/boards/{boardID}/players/{playerID}")
    public ResponseEntity<?> joinBoard(@PathVariable("boardID") String boardID, @PathVariable("playerID") String playerID) {
        Board board = boardManager.joinBoard(boardID, playerID);
        if (board != null) {
            boardcastBoard(board);
            boardcastBoardState(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Error joining board");
        }
    }

    @GetMapping("/boards")
    public ResponseEntity<?> getBoards() {
        List<Board> boards = boardManager.getBoards();
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/boards/{boardID}")
    public ResponseEntity<?> getBoard(@PathVariable("boardID") String boardID) {
        Board board = boardManager.getBoard(boardID);
        if (board != null) {
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Could not find board");
        }
    }


    @PutMapping("/boards/{boardID}/players/{playerID}/start")
    public ResponseEntity<?> startGame(@PathVariable("boardID") String boardID, @PathVariable("playerID") String playerID) {
        Board board = boardManager.startGame(boardID, playerID);
        if (board != null) {
            boardcastBoard(board);
            boardcastBoardState(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Could not find board");
        }
    }

    @PutMapping("/boards/{boardID}/players/{playerID}/play/{playType}")
    public ResponseEntity<?> pickPlay(@PathVariable("boardID") String boardID, @PathVariable("playerID") String playerID, @PathVariable("playType") PlayType playType) {
        Board board = boardManager.pickPlay(boardID, playerID, playType);
        if (board != null) {
            boardcastBoard(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Could not find board");
        }
    }

    @PutMapping("/boards/{boardID}/players/{playerID}/play/draw-tickets")
    public ResponseEntity<?> drawTickets(@PathVariable("boardID") String boardID, @PathVariable("playerID") String playerID) {
        Board board = boardManager.drawTickets(boardID, playerID);
        if (board != null) {
            boardcastBoard(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Could not find board");
        }
    }

    @PutMapping("/boards/{boardID}/players/{playerID}/play/return-tickets/{ticketIds}")
    public ResponseEntity<?> returnTickets(@PathVariable("boardID") String boardID, @PathVariable("playerID") String playerID, @PathVariable("ticketIds") List<String> ticketIds) {
        Board board = boardManager.returnTickets(boardID, playerID, ticketIds);
        if (board != null) {
            boardcastBoard(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Could not find board");
        }
    }

    @PutMapping("/game/player/draw-card")
    public Board drawCard(String boardID, String playerID, int cardPosition) {
        return null;
    }

    @PutMapping("/game/player/build-track")
    public Board buildConnection(String boardID, String playerID, String connectionId, List<String> cardsToUse) {
        return null;
    }

}

