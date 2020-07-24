package com.mine.design.strategy;

/**
 * Created by jiayq24996 on 2020-07-24
 */
public class DriverTravelStrategy implements ITravelStrategy {
    @Override
    public void travel() {
        System.out.println("开车旅行");
    }
}
