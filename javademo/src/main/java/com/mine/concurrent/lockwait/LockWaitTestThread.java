package com.mine.concurrent.lockwait;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiayq24996 on 2020-10-13
 */
public class LockWaitTestThread extends Thread {

    private Lock lock;
    private Condition condition;
    private String threadName;

    public LockWaitTestThread(Lock lock, Condition condition, String threadName) {
        this.lock = lock;
        this.threadName = threadName;
        this.condition = condition;
    }

    @Override
    public void run() {
        try {
            System.out.println(threadName + " 进来了");
            lock.lock();
            System.out.println(threadName + " 获得锁");
            lock.wait();
            //condition.await();
            //condition.signal();
            System.out.println(threadName + " wait（）释放锁");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        LockWaitTestThread thread1 = new LockWaitTestThread(lock, condition, "线程1");
        thread1.start();

        Thread.sleep(1000);

        LockWaitTestThread thread2 = new LockWaitTestThread(lock, condition, "线程2");
        thread2.start();
        LockWaitTestThread thread3 = new LockWaitTestThread(lock, condition, "线程3");
        thread3.start();
    }
}
