package com.mine.design.strategy;

/**
 * Created by jiayq24996 on 2020-07-24
 */
public class TravelContext {
    private ITravelStrategy travelStrategy;

    public TravelContext(ITravelStrategy travelStrategy) {
        this.travelStrategy = travelStrategy;
    }

    public void executeStrategy() {
        travelStrategy.travel();
    }
}
