package com.mine.api.impl;

public class TestConstructorInject {
    private String name;
    private Integer age;

    /**
     * <constructor-arg name="name" value="zhangsan"/>
     * @param name
     */
    public TestConstructorInject(String name) {
        super();
        this.name = name;
        System.out.println("name=" + name);
    }

    /**
     *  <constructor-arg name="name" value="zhangsan"/>
     *  <constructor-arg name="age" value="22"/>
     * @param name
     * @param age
     */
    public TestConstructorInject(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
        System.out.println("name=" + name + ",age=" + age);
    }

}
