package com.mine.concurrent.lock;

/**
 * Created by jiayq24996 on 2020-09-09
 */
public class Producer extends Thread {
    LockTest test;

    public Producer(LockTest test) {
        this.test = test;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Object object = new Object();
            test.put(object);
            System.out.println("$$$$$ 第" + i + "次Producer " + object + "$$$$$");
        }

    }

}
