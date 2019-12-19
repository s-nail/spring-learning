package com.mine.redisson;

import org.redisson.Redisson;
import org.redisson.config.Config;

/**
 * Created by jiayq24996 on 2019-11-25
 */
public class RedissonManager {
    private static Config config = new Config();

    private static Redisson redisson = null;

    static {
        config.useSingleServer().setAddress("127.0.0.1:6379");
        redisson = (Redisson) Redisson.create(config);
    }

    public static Redisson getRedisson() {
        return redisson;
    }
}
