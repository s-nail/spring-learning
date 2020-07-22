package com.mine.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题发布
 * Created by jiayq24996 on 2020-07-21
 */
public class Subject {
    private List<IObserver> list = new ArrayList<>();

    /**
     * 事件状态
     */
    private int state;

    /**
     * 观察者注册
     *
     * @param observer
     */
    public void register(IObserver observer) {
        list.add(observer);
    }

    /**
     * 发布事件变动通知
     */
    public void notifyAllObservers() {
        for (IObserver observer : list) {
            observer.listen();
        }
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
}
