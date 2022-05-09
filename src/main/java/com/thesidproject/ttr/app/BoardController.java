package com.thesidproject.ttr.app;

import com.thesidproject.Board;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3001", maxAge = 3600)
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

    private void boardcastBoard(MockBoard board) {
        this.simpMessagingTemplate.convertAndSend("/topic/" + board.getBoardId(), board);
    }

    private void boardcastBoardState(MockBoard board) {
        this.simpMessagingTemplate.convertAndSend("/topic/boards", board);
    }


    @PostMapping("/boards")
    public ResponseEntity<?> createBoard(@RequestBody CrateBoardInput input) {
        MockBoard board = boardManager.createBoard(input.boardName, input.playerId);
        if (board != null) {
            boardcastBoard(board);
            boardcastBoardState(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Error creating player");
        }
    }

    @PostMapping("/boards/{boardId}/players/{playerId}")
    public ResponseEntity<?> joinBoard(@PathVariable("boardId") String boardId, @PathVariable("playerId") String playerId) {
        MockBoard board = boardManager.joinBoard(boardId, playerId);
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
        List<MockBoard> boards = boardManager.getBoards();
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/boards/{boardId}")
    public ResponseEntity<?> getBoard(@PathVariable("boardId") String boardId) {
        MockBoard board = boardManager.getBoard(boardId);
        if (board != null) {
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Couldnot find board");
        }
    }


    @PutMapping("/boards/{boardId}/players/{playerId}/start")
    public ResponseEntity<?> startGame(@PathVariable("boardId")String boardId, @PathVariable("playerId") String playerId) {
        MockBoard board = boardManager.startGame(boardId, playerId);
        if (board != null) {
            boardcastBoard(board);
            boardcastBoardState(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Couldnot find board");
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

