package com.mine.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jiayq24996 on 2019-12-19
 */
public class HashMapTest {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLock lock = new ReentrantLock(true);
        Condition condition = lock.newCondition();
        condition.awaitUninterruptibly();
        condition.await();

        boolean flag = lock.tryLock();
        System.out.println("===========================" + flag);

        try {
            lock.lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        lock.unlock();

       /* Map<String, String> map = new HashMap<>(1);
        System.out.println("===========================" + map.size());
        map.put(null, "12");
        map.put(null, "11");
        map.put("n", "11");
        map.put("m", "12");
        System.out.println("===========================" + map.get(null));

        System.out.println("===========================" + map.size());*/
       /* ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("你还好嘛？");
        System.out.println(threadLocal.get());*/
    }
}
