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
            if(playType == PlayType.drawTickets) {
                board = boardManager.drawTickets(boardID, playerID);
            }
            boardcastBoard(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Could not find board");
        }
    }

    @PutMapping("/boards/{boardID}/players/{playerID}/play/reset-play-type")
    public ResponseEntity<?> resetPlayType(@PathVariable("boardID") String boardID, @PathVariable("playerID") String playerID) {
        Board board = boardManager.resetPlayType(boardID, playerID);
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

    @PutMapping("/boards/{boardID}/players/{playerID}/play/return-tickets")
    public ResponseEntity<?> returnTickets(@PathVariable("boardID") String boardID, @PathVariable("playerID") String playerID, @RequestBody ReturnTicketsInput returnTicketsInput) {
        Board board = boardManager.returnTickets(boardID, playerID, returnTicketsInput.ticketIDs);
        if (board != null) {
            boardcastBoard(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Could not find board");
        }
    }

    @PutMapping("/boards/{boardID}/players/{playerID}/play/draw-card/{cardIndex}")
    public ResponseEntity<?> drawCard(@PathVariable("boardID") String boardID, @PathVariable("playerID") String playerID, @PathVariable("cardIndex") int cardIndex) {
        Board board = boardManager.drawCard(boardID, playerID, cardIndex);
        if (board != null) {
            boardcastBoard(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Could not find board");
        }
    }

    @PutMapping("/boards/{boardID}/players/{playerID}/play/build-track")
    public ResponseEntity<?> buildTrack(@PathVariable("boardID") String boardID, @PathVariable("playerID") String playerID, @RequestBody BuildTrackInput buildTrackInput) {
        Board board = boardManager.buildTrack(boardID, playerID, buildTrackInput);
        if (board != null) {
            boardcastBoard(board);
            return ResponseEntity.ok(board);
        } else {
            return returnErrorResponse("Could not find board");
        }
    }

}

