package com.mine.redisson;

import java.util.concurrent.CountDownLatch;

/**
 * Created by jiayq24996 on 2020-10-29
 */
public class MultiThreadLockTest extends Thread {
    private String threadName;
    private Do doo;
    private CountDownLatch latch;

    public MultiThreadLockTest(String threadName, Do doo, CountDownLatch latch) {
        this.threadName = threadName;
        this.doo = doo;
        this.latch = latch;
    }

    @Override
    public void run() {
        doo.test(threadName);
        latch.countDown();
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(11);
        Do doo = new Do();
        for (int i = 0; i < 10; i++) {
            MultiThreadLockTest lockTest = new MultiThreadLockTest("Thread" + i, doo, latch);
            lockTest.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运行结束");
    }
}
