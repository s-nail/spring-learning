package com.mine.designpattern;

public class TestInner {
    private String str = "外部类中的字符串";

    //定义一个内部类
    class Inner {
        private String inStr = "内部类中的字符串";

        //定义一个普通方法
        public void print() {
            //调用外部类的str属性
            System.out.println(str);
        }
    }

    //**************************
    //在外部类中定义一个方法，该方法负责产生内部类对象并调用print()方法
    public void fun() {
        //内部类对象
        Inner in = new Inner();
        //内部类对象提供的print
        in.print();
        System.out.println("fun=============" + str);
    }

    public static void main(String[] args) {
        //创建外部类对象
        TestInner out = new TestInner();
        //外部类方法
        out.fun();
    }
}


