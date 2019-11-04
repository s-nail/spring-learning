package com.mine.examination;

/**
 * finally块的语句在try或catch中的return语句执行之后返回之前执行
 * 若finally里也有return语句则覆盖try或catch中的return语句直接返回
 *
 * Created by jiayq24996 on 2019-11-04
 */
public class FinallyAndReturnTest {
    public static String test() {
        String result;
        try {
            result = "try";
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //finally里的修改语句可能影响也可能不影响try或catch中 return已经确定的返回值
            result = "finally";
            //return result;
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(test());
    }
}
