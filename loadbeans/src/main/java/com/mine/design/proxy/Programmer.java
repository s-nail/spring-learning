package com.mine.design.proxy;

/**
 * Created by jiayq24996 on 2020-07-24
 */
public class Programmer implements FindLover {
    private String name;

    public Programmer(String name) {
        this.name = name;
    }

    @Override
    public void findLove() {
        System.out.println("I am a Programmer,this is my girlfriend,her name is " + name);
    }
}
