package com.mine.collection;

import java.util.HashSet;

/**
 * Created by jiayq24996 on 2020-08-12
 */
public class HashSetTest {

    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("test");
        set.add("test");
        set.add("test1");
        set.forEach(s-> System.out.println(s));
    }

}
