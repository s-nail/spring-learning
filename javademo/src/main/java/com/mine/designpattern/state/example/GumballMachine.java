package com.mine.designpattern.state.example;

/**
 * Created by jiayq24996 on 2020-01-03
 */
public class GumballMachine extends State{
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public void insertQuarter() {
        
    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
