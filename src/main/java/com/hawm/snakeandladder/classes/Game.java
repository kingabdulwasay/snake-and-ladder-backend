package com.hawm.snakeandladder.classes;

import java.util.*;

public class Game {
    private List<Player> players;
    private Board board;
    private static Random dice = new Random();


    public static int rollDice() {
        return dice.nextInt(6) + 1;
    }


}