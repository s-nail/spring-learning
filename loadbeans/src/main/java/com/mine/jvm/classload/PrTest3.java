package com.mine.jvm.classload;

/**
 * 常量在编译阶段会存入调用类的常量池中，
 * 本质上并没有直接引用到定义常量的类，
 * 因此不会触发定义常量的类的初始化
 */
public class PrTest3 {
    public static void main(String[] args) {
        System.out.println(ConstClass.COUNT);
        //System.out.println(ConstClass.TEST);
    }
}

class ConstClass {
    static final String TEST = new String("test");
    static final int COUNT = 1;

    static {
        System.out.println("Initialize class ConstClass");
    }
}
