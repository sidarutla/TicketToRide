package com.thesidproject.ttr.app;

import com.thesidproject.Player;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@CrossOrigin(origins = {"http://localhost:3001", "http://192.168.86.105:3001"}, maxAge = 3600)
@RestController
@Controller
public class PlayerController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    PlayerManager playerManager;

    private ResponseEntity<JSONObject> returnErrorResponse(String errorMessage) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("error", errorMessage);
        return ResponseEntity.badRequest().body(jsonObject);
    }

    @PostMapping("/players/{playerName}")
    public ResponseEntity<?> createPlayer(@PathVariable("playerName") String playerName) {
        Player player = playerManager.createPlayer(playerName);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            return returnErrorResponse("Error creating player");
        }
    }

    @GetMapping("/players/{playerID}")
    private ResponseEntity<?> getPlayer(@PathVariable("playerID") String playerID) {
        Player player = playerManager.getPlayer(playerID);
        if (player != null) {
            return ResponseEntity.ok(player);
        } else {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("error", "Player not found");
            return ResponseEntity.badRequest().body(jsonObject);
        }
    }
}

