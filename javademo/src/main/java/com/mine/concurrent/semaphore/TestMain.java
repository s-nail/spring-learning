package com.mine.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by jiayq24996 on 2020-08-19
 */
public class TestMain {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(0);
        System.out.println(semaphore.availablePermits());
        semaphore.release();
        semaphore.release();
        System.out.println(semaphore.availablePermits());
        semaphore.acquire();
        System.out.println(semaphore.availablePermits());
    }
}
