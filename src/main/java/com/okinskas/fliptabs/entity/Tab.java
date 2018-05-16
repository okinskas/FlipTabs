package com.okinskas.fliptabs.entity;

public class Tab {

    private int state;
    public final int x;
    public final int y;

    public Tab(int x, int y) {
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
