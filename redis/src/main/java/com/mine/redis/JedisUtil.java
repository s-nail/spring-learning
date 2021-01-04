package com.mine.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by jiayq24996 on 2019-11-12
 */
public class JedisUtil {
    public static Jedis getDefaultJedis() {
        return getJedis("127.0.0.1", 6379);
    }

    public static Jedis getJedis(String host, int port) {
        Jedis jedis = new Jedis(host, port);
        return jedis;
    }

    public static Jedis getDefaultJedisFromPool() {
        return getJedisFromPool("127.0.0.1", 6379);
    }

    public static Jedis getJedisFromPool(String host, int port) {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(10);
        //最大空闲连接数
        config.setMaxIdle(2);
        JedisPool jedisPool = new JedisPool(config);
        return jedisPool.getResource();
    }

    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedisFromPool("127.0.0.1", 6379);
        //Jedis jedis = JedisUtil.getJedisFromPool("127.0.0.1", 6379);
        jedis.set("flag", "1");
        System.out.println(jedis.get("name"));
    }
}
