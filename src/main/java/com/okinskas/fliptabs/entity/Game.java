package com.okinskas.fliptabs.entity;

public class Game {

    private final Board board;

    public Game() {
        board = new Board();
    }

    public Board getBoard() {
        return board;
    }

    public boolean hasWon() {
        for (int i = 0; i < Board.BOARD_X; i++) {
            for (int j = 0; j < Board.BOARD_Y; j++) {
                if (board.getTabState(i, j) == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}