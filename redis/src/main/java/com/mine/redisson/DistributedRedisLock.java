package com.mine.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;

import java.util.concurrent.TimeUnit;

/**
 * Created by jiayq24996 on 2019-11-25
 */
public class DistributedRedisLock {
    private static Redisson redisson = RedissonManager.getRedisson();
    private static final String LOCK_TITLE = "redisLock_";

    /**
     * 阻塞式 获取锁
     *
     * @param lockName
     * @return
     */
    public static boolean acquire(String lockName) {
        //声明key对象
        String key = LOCK_TITLE + lockName;
        //获取锁对象
        RLock rLock = redisson.getLock(key);
        //加锁，并且设置锁过期时间，防止死锁的产生
        rLock.lock(20, TimeUnit.SECONDS);
       // System.err.println("======lock======" + Thread.currentThread().getName());
        return true;
    }

    /**
     * 锁的释放
     *
     * @param lockName
     */
    public static void release(String lockName) {
        //必须是和加锁时的同一个key
        String key = LOCK_TITLE + lockName;
        //获取所对象
        RLock rLock = redisson.getLock(key);
        //释放锁（解锁）
        rLock.unlock();
        //System.err.println("=====unlock=====" + Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        String key = "test123";
        //加锁
        boolean b = DistributedRedisLock.acquire(key);
        System.out.println("**********" + b);
        //TODO... 执行具体业务逻辑

        //释放锁
        DistributedRedisLock.release(key);
    }
}
