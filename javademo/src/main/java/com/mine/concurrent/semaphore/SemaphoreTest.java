package com.mine.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by jiayq24996 on 2020-08-18
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        //初始化5个车位
        Semaphore semaphore = new Semaphore(5);
        for (int i = 1; i < 11; i++) {
            new Car(i, semaphore).start();
        }

    }

    static class Car extends Thread {
        private int carNo;
        private Semaphore semaphore;

        public Car(int carNo, Semaphore semaphore) {
            this.carNo = carNo;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                //获取许可（车位）
                semaphore.acquire();
                System.out.println("第" + carNo + "辆车占用一个车位");
                Thread.sleep(2000L);
                System.out.println("第" + carNo + "辆车走喽");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
