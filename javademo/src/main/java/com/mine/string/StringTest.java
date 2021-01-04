package com.mine.string;

/**
 * Created by jiayq24996 on 2020-08-18
 */
public class StringTest {
    public static void main(String[] args) {
        String a = "Hollis";
        String aa = "Hollis";
        System.out.println(a == aa);
        String b = new String("Hollis");
        String c = b.intern();
        System.out.println(a == b);
        System.out.println(a == c);
        System.out.println(b == c);
    }

    private void test(){
        String wechat = "Hollis";
        String introduce = "每日更新Java相关技术文章";
        String hollis = wechat + "," + introduce;
        System.out.println(hollis);
       /* for (int i = 0; i < 100; i++) {

        }*/
    }
}
