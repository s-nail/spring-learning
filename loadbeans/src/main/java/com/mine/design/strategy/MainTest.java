package com.mine.design.strategy;

/**
 * Created by jiayq24996 on 2020-07-24
 */
public class MainTest {
    public static void main(String[] args) {
        ITravelStrategy travelStrategy= new RunTravelStrategy();
        TravelContext context = new TravelContext(travelStrategy);
        context.executeStrategy();
        travelStrategy= new DriverTravelStrategy();
        context = new TravelContext(travelStrategy);
        context.executeStrategy();
    }
}
