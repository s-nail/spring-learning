package com.mine.designpattern.state;

/**
 * 状态模式和策略模式对比：https://www.runoob.com/w3cnote/state-vs-strategy.html
 * Created by jiayq24996 on 2020-01-02
 */
public class Tester {
    public static void main(String[] args) {
        Context context = new Context();

        BasketballState basketballState = new BasketballState();
        basketballState.doAction(context);
        System.out.println(context.getState().toString());

        PingPangState pingPangState = new PingPangState();
        pingPangState.doAction(context);
        System.out.println(context.getState().toString());

    }
}
