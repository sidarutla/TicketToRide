package com.thesidproject.ttr.app;


import com.thesidproject.Board;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
public class GameManager {

    private static Map<String, Board> boards = new HashMap<>();


    public Board createBoard(String playerName) {
        return null;
    }

    public String joinBoard(String boardId, String playerName) {
        return null;
    }

    public Board startGame(String boardId, String playerId) {
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

    public Board getBoard(String boardId) {
        return boards.get(boardId);
    }
}
