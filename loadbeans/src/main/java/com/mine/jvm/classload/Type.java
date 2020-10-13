package com.mine.jvm.classload;

/**
 * Created by jiayq24996 on 2020-08-05
 */
public class Type {
    public static final String str = new String("abc");
    static {
        System.out.println("Type init");
    }
}
