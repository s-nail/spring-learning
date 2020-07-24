package com.mine.design.strategy;

/**
 * Created by jiayq24996 on 2020-07-24
 */
public class RunTravelStrategy implements ITravelStrategy {
    @Override
    public void travel() {
        System.out.println("徒步旅行");
    }
}
