package com.mine;

import com.mine.api.Person;
import com.mine.api.impl.Chinese;
import com.mine.api.impl.StoneAxe;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionReader;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.util.Arrays;

/**
 * 梳理一下Spring初始化过程：
 *
 * 1、首先初始化上下文，生成ClassPathXmlApplicationContext对象，在获取resourcePatternResolver对象将xml解析成Resource对象。
 * 2、利用1生成的context、resource初始化工厂，并将resource解析成beandefinition,再将beandefinition注册到beanfactory中。
 *
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
        //Resource
       // BeanDefinition
        //BeanDefinitionReader
        //ServletContextResourcePatternResolver
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        Arrays.asList(ctx.getBeanDefinitionNames()).stream().forEach(x -> System.out.println("=============" + x));

    }


}