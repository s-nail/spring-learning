package com.mine.designpattern.state;

/**
 * Created by jiayq24996 on 2020-01-02
 */
public class BasketballState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("play basketball");
        context.setState(this);
    }

    @Override
    public String toString(){
        return "Basketball";
    }

}
