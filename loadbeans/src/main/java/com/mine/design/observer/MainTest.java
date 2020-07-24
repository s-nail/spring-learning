package com.mine.design.observer;

/**
 * Created by jiayq24996 on 2020-07-24
 */
public class MainTest {
    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();
        new Test1Observer(publisher);
        new Test2Observer(publisher);
        new Test3Observer(publisher);
        publisher.setState(22);
    }
}
