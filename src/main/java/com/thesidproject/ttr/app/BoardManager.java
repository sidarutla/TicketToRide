package com.thesidproject.ttr.app;


import com.thesidproject.Board;
import com.thesidproject.GameColor;
import com.thesidproject.PlayType;
import com.thesidproject.Player;
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

    private static Map<String, Board> boards = new HashMap<>();


    public Board createBoard(String boardName, String playerID) {
        Player player = playerManager.getPlayer(playerID);
        if (player == null) {
            return null;
        }
        Board board = new Board(player, boardName);
        boards.put(board.getBoardID(), board);
        return board;
    }

    public Board joinBoard(String boardID, String playerID) {
        Player player = playerManager.getPlayer(playerID);
        if (player == null) {
            return null;
        }

        Board board = boards.get(boardID);
        if (board != null) {
            if (board.addPlayer(player)) {
                return board;
            }
        }
        return null;
    }

    public Board startGame(String boardID, String playerID) {
        Player player = playerManager.getPlayer(playerID);
        if (player == null) {
            return null;
        }

        Board board = boards.get(boardID);
        if (board != null) {
           boolean started = board.startGame(playerID);
           if (started) {
               return board;
           }
        }
        return null;
    }

    public Board pickPlay(String boardID, String playerID, PlayType playType) {
        Player player = playerManager.getPlayer(playerID);
        if (player == null) {
            return null;
        }

        Board board = boards.get(boardID);
        if (board != null) {
            boolean pickedPlayType = board.pickPlayType(playerID, playType);
            if (pickedPlayType) {
                return board;
            }
        }
        return null;
    }

    public Board drawTickets(String boardID, String playerID) {
        Player player = playerManager.getPlayer(playerID);
        if (player == null) {
            return null;
        }

        Board board = boards.get(boardID);
        if (board != null) {
            boolean pickedPlayType = board.drawTickets(playerID);
            if (pickedPlayType) {
                return board;
            }
        }
        return null;
    }

    public Board returnTickets(String boardID, String playerID, List<String> ticketIds) {
        Player player = playerManager.getPlayer(playerID);
        if (player == null) {
            return null;
        }

        Board board = boards.get(boardID);
        if (board != null) {
            boolean returnedTickets = board.returnTickets(playerID, ticketIds);
            if (returnedTickets) {
                return board;
            }
        }
        return null;
    }

    public Board drawCard(String boardID, String playerID, int cardPosition) {
        Player player = playerManager.getPlayer(playerID);
        if (player == null) {
            return null;
        }

        Board board = boards.get(boardID);
        if (board != null) {
            boolean returnedTickets = board.drawCard(playerID, cardPosition);
            if (returnedTickets) {
                return board;
            }
        }
        return null;
    }

    public Board buildTrack(String boardID, String playerID, BuildTrackInput buildTrackInput) {
        Player player = playerManager.getPlayer(playerID);
        if (player == null) {
            return null;
        }
        Board board = boards.get(boardID);
        if (board != null) {
            boolean returnedTickets = board.buildTrack(playerID, buildTrackInput.connectionID, buildTrackInput.locosToUse, buildTrackInput.colorToUse);
            if (returnedTickets) {
                return board;
            }
        }
        return null;
    }

    public Board getBoard(String boardID) {
        return boards.get(boardID);
    }

    public List<Board> getBoards() {
        return boards.values().stream().collect(java.util.stream.Collectors.toList());
    }
}
