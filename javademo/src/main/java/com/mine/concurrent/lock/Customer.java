package com.mine.concurrent.lock;

/**
 * Created by jiayq24996 on 2020-09-09
 */
public class Customer extends Thread {
    LockTest test;

    public Customer(LockTest test) {
        this.test = test;
    }

    @Override
    public void run() {

        for (int i = 0; i < 100; i++) {
            Object object = test.get();
            System.out.println("******* 第" + i + "次Customer " + object + "*****");
        }
    }

}
