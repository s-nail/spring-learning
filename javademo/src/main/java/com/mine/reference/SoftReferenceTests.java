package com.mine.reference;

import java.lang.ref.SoftReference;

/**
 * 对于软引用关联着的对象，只有在内存不足的时候JVM才会回收该对象
 * 这个特性很适合用来实现缓存：比如网页缓存、图片缓存等。
 *
 * Created by jiayq24996 on 2019-12-10
 */
public class SoftReferenceTests {
    public static void main(String[] args) {
        SoftReference<String> sr = new SoftReference<>("Hello SoftReference");
        System.out.println(sr.get());
        System.gc();
        System.out.println(sr.get());
    }
}
