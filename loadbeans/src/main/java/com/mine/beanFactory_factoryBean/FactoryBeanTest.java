package com.mine.beanFactory_factoryBean;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by jiayq24996 on 2020-10-13
 */
public class FactoryBeanTest implements FactoryBean<Student> {
    private String name;
    private int age;

    @Override
    public Student getObject() throws Exception {
        System.out.println("FactoryBean<Student>");
        return new Student(name, age);
    }

    @Override
    public Class<?> getObjectType() {
        return Student.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
