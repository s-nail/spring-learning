package com.mine.design.observer;

/**
 * Created by jiayq24996 on 2020-07-24
 */
public class Test3Observer implements IObserver {
    private EventPublisher publisher;

    public Test3Observer(EventPublisher publisher) {
        this.publisher = publisher;
        publisher.register(this);
    }

    @Override
    public void subscibe() {
        System.out.println("Test3Observer监听到状态变化：" + publisher.getState());
    }
}
