package com.mine.redisson;

/**
 * Created by jiayq24996 on 2020-10-29
 */
public class Do {
    private static String key = "test123";

    public void test(String threadName) {
        boolean b = DistributedRedisLock.acquire(key);
        System.out.println("线程" + threadName + "获取锁**********" + b);
        //TODO... 执行具体业务逻辑
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //释放锁
        DistributedRedisLock.release(key);
        System.out.println("线程" + threadName + "释放锁**********" + b);
    }
}
