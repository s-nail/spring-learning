package com.mine.spi.impl;

import com.mine.spi.IShout;

public class Dog implements IShout {
    @Override
    public void shout() {
        System.out.println("wang wang");
    }
}