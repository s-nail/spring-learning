package com.mine.concurrent.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiayq24996 on 2020-09-09
 */
public class LockTest {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private List<Object> list = new ArrayList<>(2);

    public void put(Object object) {
        lock.lock();
        try {
            while (list.size() == 2) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(object);
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object get() {
        Object object;
        lock.lock();
        try {
            while (list.size() == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            object = list.get(0);
            list.remove(0);
            condition.signal();
        } finally {
            lock.unlock();
        }
        return object;
    }

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        Producer producer = new Producer(lockTest);
        producer.start();
        Customer customer = new Customer(lockTest);
        customer.start();
    }
}
