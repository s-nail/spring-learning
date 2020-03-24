package com.mine.designpattern.state.example;

/**
 * Created by jiayq24996 on 2020-01-03
 */
public abstract class State {
    /**
     * 投币
     */
    public abstract void insertQuarter();

    /**
     * 退币
     */
    public abstract void ejectQuarter();

    /**
     * 转动出糖曲轴
     */
    public abstract void turnCrank();

    /**
     * 发糖
     */
    public abstract void dispense();


    protected void returnQuarter() {
        System.out.println("退币……");
    }

}
