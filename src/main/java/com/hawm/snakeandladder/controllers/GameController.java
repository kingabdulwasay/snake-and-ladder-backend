package com.hawm.snakeandladder.controllers;
import com.hawm.snakeandladder.classes.Game;
import com.hawm.snakeandladder.classes.Player;
import com.hawm.snakeandladder.repositories.DatabaseConnection;
import com.hawm.snakeandladder.services.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @CrossOrigin("http://127.0.0.1:5500/")
    @PostMapping("/addplayer")
    public Player addPlayers(@RequestBody Player player){
       return gameService.addPlayers(player);
    }

    @CrossOrigin("http://127.0.0.1:5500/")
    @GetMapping("/getplayer")
    public ArrayList<Player> getAllPlayers(){
        return gameService.getAllPlayers();
    }

    @CrossOrigin("http://127.0.0.1:5500/")
    @GetMapping("/roll")
    public String rollDice(){
       return Integer.toString(gameService.rollDice());
    }

    @CrossOrigin("http://127.0.0.1:5500/")
    @PostMapping("/move")
    public Player updatePlayer(@RequestParam String name, @RequestParam int newposition){
        return gameService.updatePlayer(name, newposition);
    }

    @CrossOrigin("http://127.0.0.1:5500/")
    @GetMapping("/wins")
    public ArrayList<String> showWins(){
        return gameService.showMatches();
    }



}
