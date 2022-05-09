package com.thesidproject.ttr.app;


import com.thesidproject.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
public class BoardManager {

    @Autowired
    PlayerManager playerManager;

    private static Map<String, MockBoard> boards = new HashMap<>();


    public MockBoard createBoard(String boardName, String playerId) {

        MockPlayer player = playerManager.getPlayer(playerId);
        if (player == null) {
            return null;
        }

        MockBoard board = new MockBoard(boardName, player);
        boards.put(board.getBoardId(), board);
        return board;


    }

    public MockBoard joinBoard(String boardId, String playerId) {
        MockPlayer player = playerManager.getPlayer(playerId);
        if (player == null) {
            return null;
        }

        MockBoard board = boards.get(boardId);
        if (board != null) {
            if (board.addPlayer(player)) {
                return board;
            }
        }
        return null;
    }

    public MockBoard startGame(String boardId, String playerId) {
        MockPlayer player = playerManager.getPlayer(playerId);
        if (player == null) {
            return null;
        }

        MockBoard board = boards.get(boardId);
        if (board != null) {
           boolean started = board.startGame(playerId);
           if (started) {
               return board;
           }
        }
        return null;
    }

    public Board pickPlay(String boardId, String playerId) {
        return null;
    }

    public Board drawTickets(String boardId, String playerId) {
        return null;
    }

    public Board returnTickets(String boardId, String playerId, List<String> ticketIds) {
        return null;
    }

    public Board drawCard(String boardId, String playerId, int cardPosition) {
        return null;
    }

    public Board buildConnection(String boardId, String playerId, String connectionId) {
        return null;
    }

    public MockBoard getBoard(String boardId) {
        return boards.get(boardId);
    }

    public List<MockBoard> getBoards() {
        return boards.values().stream().collect(java.util.stream.Collectors.toList());
    }
}
