package com.mine.concurrent.lockwait;

/**
 * Created by jiayq24996 on 2020-10-13
 */
public class SynchronizedWaitTestThread extends Thread {

    private Object lock;
    private String threadName;

    public SynchronizedWaitTestThread(Object lock, String threadName) {
        this.lock = lock;
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(threadName + " 进来了");
        synchronized (lock) {
            try {
                System.out.println(threadName + " 获得锁");
                lock.wait();
                //condition.await();
                //condition.signal();
                System.out.println(threadName + " wait（）释放锁");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        SynchronizedWaitTestThread thread1 = new SynchronizedWaitTestThread(lock, "线程1");
        thread1.start();

        Thread.sleep(1000);

        SynchronizedWaitTestThread thread2 = new SynchronizedWaitTestThread(lock, "线程2");
        thread2.start();
        SynchronizedWaitTestThread thread3 = new SynchronizedWaitTestThread(lock, "线程3");
        thread3.start();
    }
}
