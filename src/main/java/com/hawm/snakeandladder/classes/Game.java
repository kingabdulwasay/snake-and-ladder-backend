package com.hawm.snakeandladder.classes;

import java.util.*;

public class Game {
    private List<Player> players;
    private Board board;
    private static Random dice = new Random();
    private Scanner scanner;



    public void play() {
        boolean gameWon = false;
        while (!gameWon) {
            for (Player player : players) {
                System.out.println(player.getName() + ", press Enter to roll the dice.");
                scanner.nextLine();

                int diceRoll = dice.nextInt();
                System.out.println(player.getName() + " rolled a " + diceRoll);

                int newPosition = player.getPosition() + diceRoll;
                if (newPosition >= 99) {
                    System.out.println(player.getName() + "  IS THE WINNER!!!!");
                    gameWon = true;
                    break;
                }

                int moveEffect = board.getMoveEffect(newPosition);
                if (moveEffect != 0) {
                    if (moveEffect > 0) {
                        System.out.println(player.getName() + " found a ladder and climbed to " + (newPosition + moveEffect));
                    } else {
                        System.out.println(player.getName() + " WAS BIT BY A SNAKE AND WENT BACK to " + (newPosition + moveEffect));

                    }
                    newPosition += moveEffect;
                }

                player.setPosition(newPosition);
                System.out.println(player.getName() + " is now at position " + newPosition);
            }
        }
    }
    public static int rollDice() {
        return dice.nextInt(6) + 1;
    }
    public static void snake(Player player, int position){

    }

}