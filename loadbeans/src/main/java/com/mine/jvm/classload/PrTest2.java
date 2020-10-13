package com.mine.jvm.classload;

/**
 * 通过数组来定义引用类，不会触发此类的初始化
 */
public class PrTest2 {
    public static void main(String[] args) {
        E[] e = new E[10];
    }
}

class E{
    static{
        System.out.println("Initialize class E");
    }
}