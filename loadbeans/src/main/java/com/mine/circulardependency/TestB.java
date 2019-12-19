package com.mine.circulardependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by jiayq24996 on 2019-11-28
 */
@Component
public class TestB {
    @Autowired
    private TestA testA;

    public void say() {
        System.out.println("I am TestB");
    }
}
