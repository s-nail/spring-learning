package com.mine.design.observer;

/**
 * Created by jiayq24996 on 2020-07-24
 */
public class Test2Observer implements IObserver {
    private EventPublisher publisher;

    public Test2Observer(EventPublisher publisher) {
        this.publisher = publisher;
        publisher.register(this);
    }

    @Override
    public void subscibe() {
        System.out.println("Test2Observer监听到状态变化：" + publisher.getState());
    }
}
