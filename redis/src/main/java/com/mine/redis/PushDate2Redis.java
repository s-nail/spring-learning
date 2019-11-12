package com.mine.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

/**
 * 使用setnx和set指令实现分布式锁
 * Created by jiayq24996 on 2019-11-12
 */
public class PushDate2Redis {
    private static void pushLargeNumberOfStrDate() {
        Jedis jedis = JedisUtil.getDefaultJedis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i + ":" + jedis.setex("name" + i, 60, "Lee" + i));
        }

    }

    /**
     * 将 key 的值设为 value ，当且仅当 key 不存在。
     * <p>
     * 若给定的 key 已经存在，则 SETNX 不做任何动作。
     * <p>
     * SETNX 是『SET if Not eXists』(如果不存在，则 SET)的简写。
     */
    private static void lock() throws InterruptedException {
        Jedis jedis = JedisUtil.getDefaultJedis();
        Long res = jedis.setnx("Lock", "true");
        //1.手动释放锁
        jedis.del("Lock");
        //2.给锁设置过期时间，但是setnx和expire非原子操作
        /*jedis.expire("Lock", 2);
        System.out.println(res);
        Thread.sleep(2500);
        */


        Long res2 = jedis.setnx("Lock", "true");
        System.out.println(res2);

        //Redis 2.8 版本中作者加入了 set 指令的扩展参数，使得 setnx 和 expire 指令可以一起执行
        /**
         * set key value [EX seconds] [PX milliseconds] [NX|XX]
         * EX seconds：设置失效时长，单位秒
         * PX milliseconds：设置失效时长，单位毫秒
         * NX：key不存在时设置value，成功返回OK，失败返回(nil)
         * XX：key存在时设置value，成功返回OK，失败返回(nil)
         */
        SetParams params = new SetParams();
        params.nx();
        params.ex(2);
        String res3 = jedis.set("Lock2", "true", params);
        System.out.println("res3:" + res3);
        //延时2.5秒
        Thread.sleep(2500);

        String res4 = jedis.set("Lock2", "true", params);
        System.out.println("res4:" + res4);
    }

    public static void main(String[] args) throws InterruptedException {
        //pushLargeNumberOfStrDate();
        lock();
    }
}
