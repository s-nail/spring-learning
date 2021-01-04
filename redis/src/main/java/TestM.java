import com.mine.redis.JedisUtil;
import redis.clients.jedis.Jedis;

/**
 * Created by jiayq24996 on 2020-12-01
 */
public class TestM {
    public static void main(String[] args) {
        Jedis jedis = JedisUtil.getJedisFromPool("127.0.0.1", 6379);
        Long haha = jedis.setnx("TEst", "Lock");
        System.out.println(haha);
    }
}
