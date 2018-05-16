package com.okinskas.fliptabs.entity;

public class Tab {

    private int state;

    public Tab() {
        state = 0;
    }

    public void flip() {
        state = state == 0 ? 1 : 0;
    }

    public int getState() {
        return state;
    }
}
