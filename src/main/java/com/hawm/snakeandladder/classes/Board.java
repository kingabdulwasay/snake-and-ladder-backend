package com.hawm.snakeandladder.classes;
public abstract class Board {
    protected final int[][] board;

    public Board() {
        board = new int[10][10];
        initializeSnakesAndLadders();
    }

    protected abstract void initializeSnakesAndLadders();

    public int getMoveEffect(int position) {
        int row = position / 10;
        int col = position % 10;
        return board[row][col];
    }
}