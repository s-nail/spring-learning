package com.mine.aliexamination;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    private final static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        try {
            //lock.tryLock();
            System.out.println("pass here");
            //lock.lock();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}