package com.mine.concurrent.countDownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Work implements Runnable {


    private CountDownLatch downLatch;
    private String name;

    public Work(CountDownLatch downLatch, String name) {
        this.downLatch = downLatch;
        this.name = name;
    }

    @Override
    public void run() {
        this.doWork();
        try {
            TimeUnit.SECONDS.sleep(new Random().nextInt(10));
        } catch (InterruptedException ie) {
        }
        System.out.println(this.name + "活干完了！还有几个人未完成：" + (downLatch.getCount() - 1));

        this.downLatch.countDown();

    }

    private void doWork() {
        System.out.println(this.name + "正在干活!");
    }
}
