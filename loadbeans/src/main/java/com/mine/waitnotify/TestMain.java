package com.mine.waitnotify;

/**
 * Created by jiayq24996 on 2020-08-06
 */
public class TestMain {
    public static volatile int i = 1;

    public static void main(String[] args) {
        //同一个object对象锁
        Object object = new Object();
        new OddNumberPrint(object).start();
        new EvenNumberPrint(object).start();
    }
}
