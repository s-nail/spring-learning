package com.mine.waitnotify;

/**
 * 偶数打印，2、4、6、8...100
 * Created by jiayq24996 on 2020-08-06
 */
public class EvenNumberPrint extends Thread {
    private Object lock;
    public EvenNumberPrint(Object lock) {
        this.lock = lock;
    }
    @Override
    public void run() {
        int i = 1;
        while (i++ <= 100) {
            synchronized (lock) {
                if (i % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i % 2 == 0) {
                    System.out.println(i);
                }
                lock.notify();
            }
        }
    }
}
