package com.mine.clazz;

/**
 * Created by jiayq24996 on 2019-11-25
 */
public class TestClass {
    public static void main(String[] args) {

        try {
            Test test = (Test) Class.forName("com.mine.clazz.Test").newInstance();
            System.out.println(test);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
