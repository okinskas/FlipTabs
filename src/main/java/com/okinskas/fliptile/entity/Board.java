package com.okinskas.fliptile.entity;

public class Board {

    public static final int BOARD_X = 5;
    public static final int BOARD_Y = 3;

    private Tile[][] boardArray = new Tile[BOARD_X][BOARD_Y];

    Board() {
        for (int x = 0; x < BOARD_X; x++) {
            for (int y = 0; y < BOARD_Y; y++) {
                boardArray[x][y] = new Tile(x, y);
            }
        }
    }

    public Tile getTab(int x, int y) {
        if (x < 0 || x >= BOARD_X || y < 0 || y >= BOARD_Y) {
            return null;
        }
        return boardArray[x][y];
    }

    public int getTabState(int x, int y) {
        return getTab(x, y).getState();
    }

    public void flipSequence(int x, int y) {

        for (int i = 0; i < BOARD_X; i++) {
            for (int j = 0; j < BOARD_Y; j++) {
                if ((i == x && j == y)
                        || (i == x && (j == y - 1 || j == y + 1))
                        || (j == y && (i == x - 1 || i == x + 1))) {
                    boardArray[i][j].flip();
                }
            }
        }
    }
}
