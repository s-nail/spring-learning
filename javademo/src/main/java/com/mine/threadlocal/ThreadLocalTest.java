package com.mine.threadlocal;

/**
 * Created by jiayq24996 on 2020-01-16
 */
public class ThreadLocalTest {
    public static void main(String[] args) {

        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("哈哈");
        System.out.println(threadLocal.get());
    }
}
