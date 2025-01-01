package com.hawm.snakeandladder.classes;

import java.util.*;

public class Game {


    private Random dice = new Random();

    public int rollDice() {
        return dice.nextInt(6) + 1;
    }


}