package com.mine.designpattern.observer;

/**
 * Created by jiayq24996 on 2020-07-21
 */
public class Tester {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new Test1IObserver(subject);
        new Test2IObserver(subject);
        new Test3IObserver(subject);

        subject.setState(11);
    }
}
