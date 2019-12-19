package com.mine.generic;

public class MyTransform implements BaseTransform<Double> {


    @Override
    public <T> Double parseTag(T t) {
        String s = (String) t;
        return null;
    }

    public static void main(String[] args) {
        MyTransform myTransform = new MyTransform();
        String a = "";
        Double d = myTransform.parseTag(a);
    }
}