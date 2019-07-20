package com.mine;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MeiPo implements MethodInterceptor {
    public Object getInstance(Object obj) {
        //通过反射进行实例化
        Enhancer enhancer =new Enhancer();
        //把父类设置为谁？
        //这一步就是告诉cglib，生成的子类需要继承哪个类
        enhancer.setSuperclass(obj.getClass());
        //设置回调
        enhancer.setCallback(this);
        return enhancer.create();
    }

    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("我是媒婆，开始海选");
        //这个o的引用是由CGLib给我们new出来的
        //CGLib new出来的对象，是被代理对象的子类（继承了我们自己写的那个类）
        //OOP 在new子类之前，实际上默认先调用了我们super()风法的
        //创建子类的同时，必须先new出来父类，这就相当于间接持有我们父类的引用
        //子类重写了父类的所有方法，我们改变子类对象的某些属性，是可以间接的操作父类的属性的
        methodProxy.invokeSuper(o,objects);
        //
        return null;
    }
}
