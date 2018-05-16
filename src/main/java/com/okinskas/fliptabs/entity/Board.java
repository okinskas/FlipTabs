package com.okinskas.fliptabs.entity;

public class Board {

    public static final int BOARD_X = 5;
    public static final int BOARD_Y = 3;

    private Tab[][] boardArray = new Tab[BOARD_X][BOARD_Y];

    public Board() {
        for (Tab[] x : boardArray) {
            for (int j = 0; j < x.length; j++) {
                x[j] = new Tab();
            }
        }
    }

    public Tab getTab(int x, int y) {
        if (x < 0 || x >= BOARD_X || y < 0 || y >= BOARD_Y) {
            return null;
        }
        return boardArray[x][y];
    }

    public int getTabState(int x, int y) {
        return getTab(x, y).getState();
    }

    public void flipSequence(int x, int y) {

        for (int i = 0; i < boardArray.length; i++) {
            for (int j = 0; j < boardArray[i].length; j++) {
                if ((i == x && (j == y - 1 || j == y + 1))
                        || (j == x && (i == y - 1 || i == y + 1))) {
                    boardArray[i][j].flip();
                }
            }
        }
    }
}
