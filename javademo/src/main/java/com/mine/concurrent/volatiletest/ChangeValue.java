package com.mine.concurrent.volatiletest;

public class ChangeValue extends Thread {
    public boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag发生变化：" + flag);
    }

}