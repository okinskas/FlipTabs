package com.okinskas.fliptile.entity;

public class Tile {

    private int state;
    public final int x;
    public final int y;

    public Tile(int x, int y) {
        state = 0;
        this.x = x;
        this.y = y;
    }

    public void flip() {
        state = state == 0 ? 1 : 0;
    }

    public int getState() {
        return state;
    }
}
