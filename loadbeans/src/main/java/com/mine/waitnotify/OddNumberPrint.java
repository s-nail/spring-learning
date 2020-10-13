package com.mine.waitnotify;

/**
 * 奇数打印，1、3、5、7...99
 * Created by jiayq24996 on 2020-08-06
 */
public class OddNumberPrint extends Thread {
    private Object lock;

    public OddNumberPrint(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        int i = 0;
        while (i++ < 100) {
            synchronized (lock) {
                if (i % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (i % 2 != 0) {
                    System.out.println(i);
                }
                lock.notify();
            }

        }
    }

}
