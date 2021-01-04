package com.mine.lock;

import com.mine.redis.JedisUtil;
import redis.clients.jedis.Jedis;

/**
 * 偶数打印
 */
public class PrinterAB2 {
    public static void main(String[] args) {
        int i = 2;
        Jedis jedis = JedisUtil.getJedisFromPool("127.0.0.1", 6379);

        while (true) {
            Integer result = Integer.valueOf(jedis.get("flag"));
            if (result == i) {
                System.out.println(i);
                i = i + 2;
                Integer result2 = result + 1;
                jedis.set("flag", result2.toString());
            }
        }
    }
}
