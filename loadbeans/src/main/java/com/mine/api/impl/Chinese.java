package com.mine.api.impl;

import com.mine.api.Axe;
import com.mine.api.Person;

public class Chinese implements Person {
    private Axe axe;

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public void useAxe() {
        System.out.println("我打算去砍点柴火");
        System.out.println(axe.chop());
    }
}