package com.mine.spi.impl;

import com.mine.spi.IShout;

public class Cat implements IShout {
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}