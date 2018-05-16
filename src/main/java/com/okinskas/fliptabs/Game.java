package com.okinskas.fliptabs;

import com.okinskas.fliptabs.entity.Board;
import com.okinskas.fliptabs.entity.Tab;

public class Game {

    public Game() {

        Board board = new Board();
    }

    public static boolean hasWon(Board board) {
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