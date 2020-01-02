package com.mine.designpattern.state;

/**
 * Created by jiayq24996 on 2020-01-02
 */
public class Context {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
