package com.mine.designpattern.observer;

/**
 * Created by jiayq24996 on 2020-07-21
 */
public class Test2IObserver implements IObserver {
    private Subject subject;

    public Test2IObserver(Subject subject) {
        this.subject = subject;
        subject.register(this);
    }

    @Override
    public void listen() {
        System.out.println("Test2IObserver监听到状态：" + subject.getState());
    }
}
