package com.mine.designpattern.state;

/**
 * Created by jiayq24996 on 2020-01-02
 */
public class PingPangState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("play PingPang");
        context.setState(this);
    }

    @Override
    public String toString(){
        return "PingPang";
    }
    
}
