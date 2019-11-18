package com.mine.java8.list;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Setter
@Getter
@ToString
public class Fruit {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
    private Double weight;

    public Fruit(Integer id, String name, BigDecimal money, Integer num, Double weight) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
        this.weight = weight;
    }
}