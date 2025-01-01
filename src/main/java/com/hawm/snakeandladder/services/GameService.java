package com.hawm.snakeandladder.services;
import com.hawm.snakeandladder.classes.Player;
import com.hawm.snakeandladder.repositories.DatabaseConnection;
import com.hawm.snakeandladder.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Random;
@Service
public class GameService {
    private ArrayList<Player> players = new ArrayList<>();
    private int playersCount = 0;
    private Random dice;
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        this.dice = new Random();
        this.playersCount = 0;
    }

    public Player addPlayers(Player player){
        playersCount++;
        players.add(player);
        return players.get(playersCount - 1);
    }

    public ArrayList<Player> getAllPlayers(){
        return players;
    }


    public int rollDice() {
        return dice.nextInt(6) + 1;
    }

    public Player updatePlayer(String name, int newposition){


            Player player;
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getName().equals(name)) {
                    player = players.get(i);
                    if (player.getPosition() + newposition == 100) {
                        gameRepository.addHistory(player.getName());

                    } else if (player.getPosition() + newposition <= 99) {
                        if (player.getPosition() + newposition == 26 ) {
                            player.downOrupPosition(3);
                            System.out.println("Snake");
                        } else if (player.getPosition() + newposition == 58) {
                            player.downOrupPosition(1);
                            System.out.println("Snake");
                        } else if (player.getPosition()+newposition == 74) {
                            player.downOrupPosition(49);
                            System.out.println("Snake");
                        } else if (player.getPosition() + newposition == 80) {
                            player.downOrupPosition(43);
                            System.out.println("Snake");
                        } else if (player.getPosition() + newposition == 93) {
                            player.downOrupPosition(18);
                            System.out.println("Snake");
                        } else if (player.getPosition()+newposition == 98) {
                            player.downOrupPosition(12);
                            System.out.println("Snake");
                        } else if (player.getPosition()+ newposition == 4) {
                            player.downOrupPosition(25);
                            System.out.println("Ladder");
                        } else if (player.getPosition() + newposition == 10) {
                            player.downOrupPosition(50);
                            System.out.println("Ladder");
                        } else if (player.getPosition() + newposition == 33) {
                            player.downOrupPosition(94);
                            System.out.println("Ladder");
                        } else if (player.getPosition() + newposition == 61) {
                            player.downOrupPosition(99);
                            System.out.println("Ladder");
                        } else if (player.getPosition() + newposition == 71) {
                            player.downOrupPosition(92);
                            System.out.println("Ladder");
                        } else {
                            player.setPosition(newposition);
                        }
                    }

                    return player;
                }

            }


        return null;
    }

    public ArrayList<String> showMatches(){
        return gameRepository.showHistory();
    }

}
