package com.mine.lru;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 最近最少使用删除策略
 * <p>
 * Created by jiayq24996 on 2019-11-14
 */
public class LRUStrategy<K, V> extends LinkedHashMap<K, V> {

    private final int CACHE_SIZE;

    /**
     * 传递进来最多能缓存多少数据
     *
     * @param cacheSize 缓存大小
     */
    public LRUStrategy(int cacheSize) {
        //true 表示让linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    /**
     * 知识点扩展：
     * LinkedHashMap有一个removeEldestEntry(Map.Entry eldest)方法，
     * 通过覆盖这个方法，加入一定的条件，满足条件返回true。
     * 当put进新的值方法返回true时，便移除该map中最老的键和值。
     * @param eldest
     * @return
     */
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > CACHE_SIZE;
    }

    public static void main(String[] args) {
        LRUStrategy lruCache = new LRUStrategy<Integer, Integer>(4);
        for (int i = 0; i < 5; i++) {
            lruCache.put(i, 1);
        }
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.put(5, 5);
        System.out.println(lruCache.get(1));
    }
}
