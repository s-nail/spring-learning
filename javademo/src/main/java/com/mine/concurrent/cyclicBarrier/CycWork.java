package com.mine.concurrent.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

public class CycWork implements Runnable {

    private CyclicBarrier cyclicBarrier;
    private String name;

    public CycWork(CyclicBarrier cyclicBarrier, String name) {
        this.name = name;
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(name + "正在打桩，毕竟不轻松。。。。。");
        try {
            Thread.sleep(5000);
            System.out.println(name + "不容易，终于把桩打完了。。。。还有几人也干完了：" + cyclicBarrier.getNumberWaiting());

            cyclicBarrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(name + "：其他逗b把桩都打完了，又得忙活了。。。");
    }
}
