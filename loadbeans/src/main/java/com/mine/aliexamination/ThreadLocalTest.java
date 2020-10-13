package com.mine.aliexamination;

/**
 * Created by jiayq24996 on 2020-07-27
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("thread1");
        threadLocal.set("main");

        System.out.println(Thread.currentThread().getName() + threadLocal.get());
        threadLocal.remove();
        System.out.println(Thread.currentThread().getName() + threadLocal.get());
    }
}
