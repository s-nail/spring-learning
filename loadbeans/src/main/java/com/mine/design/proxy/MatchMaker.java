package com.mine.design.proxy;

/**
 * Created by jiayq24996 on 2020-07-24
 */
public class MatchMaker implements FindLover {
    private Programmer programmer;
    private String name;

    public MatchMaker(String name) {
        this.name = name;
    }

    @Override
    public void findLove() {
        System.out.println("I am a MatchMaker");
        if (programmer == null) {
            programmer = new Programmer(name);
        }
        programmer.findLove();
    }


}
