package com.mine.design.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiayq24996 on 2020-07-24
 */
public class EventPublisher {
    private List<IObserver> observers = new ArrayList<>();

    private int state;


    public void register(IObserver observer){
        observers.add(observer);
    }

    private void notifyObserver(){
        for (IObserver observer : observers) {
            observer.subscibe();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObserver();
    }
}
