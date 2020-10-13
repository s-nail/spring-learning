package com.mine.concurrent.volatiletest;

/**
 * Created by jiayq24996 on 2020-09-14
 */
public class VolatileTest {
    public static void main(String[] args) {
        ChangeValue changeValue = new ChangeValue();
        changeValue.start();

        for (; ; ) {
            if (changeValue.flag) {
                System.out.println("Main线程监控到flag变化");
            }
        }

    }

}
