package com.mine.api.impl;

import com.mine.api.Axe;
import com.mine.api.Person;

public class Chinese implements Person {
    private Axe axe;

    public void setAxe(Axe axe) {
        System.out.println("调用set方法进行属性注入");
        this.axe = axe;
    }

    @Override
    public void useAxe() {
        System.out.println("我打算去砍点柴火");
        System.out.println(axe.chop());
    }

    private void init() {
        System.out.println("Chinese init");
    }
}