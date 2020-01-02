package com.mine.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jiayq24996 on 2019-12-19
 */
public class HashMapTest {

    public static void main(String[] args) {
        /*Map<String, String> map = new HashMap<>(16);
        map.put(null, null);
        System.out.println("===========================" + map.get(null));*/

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("你还好嘛？");
        System.out.println(threadLocal.get());
    }
}
