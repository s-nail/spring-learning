package com.mine.redis;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.params.SetParams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用setnx和set指令实现分布式锁
 * Created by jiayq24996 on 2019-11-12
 */
public class PushDate2Redis {
    private static void pushLargeNumberOfStrDate() {
        Jedis jedis = JedisUtil.getDefaultJedis();
        //含过期时间
        /*for (int i = 0; i < 100000; i++) {
            System.out.println(i + ":" + jedis.setex("name" + i, 60, "Lee" + i));
        }*/
        //不含过期时间
        for (int i = 0; i < 10000; i++) {
            System.out.println(i + ":" + jedis.set("name" + i, "Lee" + i));
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

    private static void Producer() {
        Jedis jedis = JedisUtil.getDefaultJedis();
        Long str = jedis.lpush("topic", "test form Producer");
        System.out.println("Producer:" + str);
    }

    private static void Customer() {
        Jedis jedis = JedisUtil.getDefaultJedis();
        String str2 = jedis.lpop("topic");
        //List<String> str2 = jedis.blpop("topic");
        System.out.println("Customer:" + str2);
    }

    public static void main(String[] args) throws InterruptedException {
        //pushLargeNumberOfStrDate();
        //lock();

//        Producer();
//        Customer();
        //Customer();

        Jedis jedis = JedisUtil.getDefaultJedis();

        jedis.set("name","Lee");
        String name = jedis.get("name");
        System.out.println(name);//输出Lee

        jedis.lpush("site-list", "Runoob");
        jedis.lpush("site-list", "Google");
        jedis.lpush("site-list", "Taobao");
        // 获取存储的数据并输出
        List<String> list = jedis.lrange("site-list", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Lee");
        map.put("age", "22");
        map.put("qq", "123456");
        map.put("phone", "123456");

        jedis.hmset("user",map);
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq","phone");
        System.out.println(rsmap);

        jedis.sadd("users","liuling");
        jedis.sadd("users","xinxin");
        jedis.sadd("users","ling");
        jedis.sadd("users","zhangxinxin");
        jedis.sadd("users","who");

        //移除noname
        //jedis.srem("users","who");
        System.out.println(jedis.smembers("users"));//获取所有加入的value
        System.out.println(jedis.sismember("users", "who"));//判断 who 是否是user集合的元素
        System.out.println(jedis.srandmember("users"));
        System.out.println(jedis.scard("users"));//返回集合的元素个数

        Person person = new Person("Lee", 25);
        Person person1 = new Person("Tom", 26);
        Person person2 = new Person("Jim", 27);

        List list1 = new ArrayList();
        list1.add(person);
        list1.add(person1);
        list1.add(person2);
        list1.add(person2);



        String listStr = JSON.toJSONString(list1);
        jedis.set("Persons", listStr);

        String token = jedis.get("Persons");
        List<Person> listCopy = JSON.parseArray(token, Person.class);

    }
}
