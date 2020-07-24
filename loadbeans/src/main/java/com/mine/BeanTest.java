package com.mine;

import com.mine.api.Person;
import com.mine.api.impl.TestConstructorInject;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 梳理一下Spring初始化过程：
 * <p>
 * 1、首先初始化上下文，生成ClassPathXmlApplicationContext对象，在获取resourcePatternResolver对象将xml解析成Resource对象。
 * 2、利用1生成的context、resource初始化工厂，并将resource解析成beandefinition,再将beandefinition注册到beanfactory中。
 */
public class BeanTest {
    public static void main(String[] args) {
        /*Chinese p = new Chinese();
        StoneAxe axe = new StoneAxe();
        p.setAxe(axe);
        p.useAxe();*/
        ApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
        Person p = ctx.getBean("chinese", Person.class);
        p.useAxe();

        TestConstructorInject testConstructorInject = ctx.getBean("testConstructorInject", TestConstructorInject.class);
//        BeanDefinitionReaderUtils
        //Resource
        // BeanDefinition
        //BeanDefinitionReader
        //ServletContextResourcePatternResolver
        //DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        //Arrays.asList(ctx.getBeanDefinitionNames()).stream().forEach(x -> System.out.println("=============" + x));
        String a = "1235";
        Integer b = 1235;
        Integer e = 1235;
        int c = 1234;
        int d = 1234;
        System.out.println(b.equals(Integer.valueOf(a)));
        System.out.println(a.equals(b + ""));
        System.out.println(b == e);
        System.out.println(c == d);
        System.out.println("=========================================");
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < 5; i++) {
            set.add(i + "");
        }
        System.out.println(set.add("2"));
        System.out.println(set.add(null));
        //BeanDefinition
        //BeanDefinitonRegistry
    }


}