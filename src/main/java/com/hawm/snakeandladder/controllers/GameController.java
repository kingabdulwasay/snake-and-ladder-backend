package com.hawm.snakeandladder.controllers;
import com.hawm.snakeandladder.classes.Game;
import com.hawm.snakeandladder.classes.Player;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GameController {

    private ArrayList<Player> players = new ArrayList<>();
    private int playersCount = 0;

    @CrossOrigin("http://127.0.0.1:5500/")
    @PostMapping("/addplayer")
    public Player addPlayers(@RequestBody Player player){
        playersCount++;
        players.add(player);
        return players.get(playersCount - 1);
    }

    @CrossOrigin("http://127.0.0.1:5500/")
    @GetMapping("/getplayer")
    public ArrayList<Player> getAllPlayers(){
        return players;
    }

    @CrossOrigin("http://127.0.0.1:5500/")
    @GetMapping("/roll")
    public String rollDice(){
       return Integer.toString(Game.rollDice());
    }

    @CrossOrigin("http://127.0.0.1:5500/")
    @PostMapping("/move")
    public Player updatePlayer(@RequestParam String name, @RequestParam int newposition){

        if (newposition !=  100) {
            Player player;
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName().equals(name)) {
                    player = players.get(i);
                    if (newposition == 26 ) {
                        player.downOrupPosition(3);
                    } else if (newposition == 58) {
                        player.downOrupPosition(1);
                    } else if (newposition == 74) {
                        player.downOrupPosition(49);
                    } else if (newposition == 80) {
                        player.downOrupPosition(43);
                    } else if (newposition == 93) {
                        player.downOrupPosition(18);
                    } else if (newposition == 98) {
                        player.downOrupPosition(12);
                    } else if (newposition == 4) {
                        player.downOrupPosition(25);
                    } else if (newposition == 10) {
                        player.downOrupPosition(50);
                    } else if (newposition == 33) {
                        player.downOrupPosition(94);
                    } else if (newposition == 61) {
                        player.downOrupPosition(99);
                    } else if (newposition == 71) {
                        player.downOrupPosition(92);
                    } else {
                        player.setPosition(newposition);
                    }
                    return player;
                }
            }
        }

        return null;
    }
}
