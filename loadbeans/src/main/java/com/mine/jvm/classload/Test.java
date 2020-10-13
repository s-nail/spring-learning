package com.mine.jvm.classload;

import sun.applet.AppletClassLoader;
import sun.misc.ClassLoaderUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by jiayq24996 on 2020-08-05
 */
public class Test {
    public static void main(String[] args) {
        //System.out.println(ClassInit.str);
        //System.out.println(ClassInit.id);
        /*System.out.println(ClassInit.map);
        //new Type();
        try {
            Class.forName("com.mine.jvm.classload.Type");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(Type.class);*/
        System.out.println(TypeSon.str);
    }
}

class ClassInit {
    /**
     * 需要初始化ClassInit类
     */
    public static final String id = new String("new");
    /**
     * 字面值常量
     */
    public static final String str = "abc";

    public static final Map<String, Type> map = new HashMap<>();

    static {
        System.out.println("ClassInit init");
    }

}
