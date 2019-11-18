package com.mine.java8.list;

import com.alibaba.fastjson.JSON;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by jiayq24996 on 2019-11-15
 */
public class ListTest {


    private static List<Fruit> initial() {
        //存放apple对象集合
        List<Fruit> fruitList = new ArrayList();
        Fruit fruit1 = new Fruit(1, "苹果1", new BigDecimal("3.25"), 10, 1.1);
        Fruit fruit12 = new Fruit(1, "苹果2", new BigDecimal("1.35"), 20, 1.8);
        Fruit fruit2 = new Fruit(2, "香蕉", new BigDecimal("2.89"), 30, 1.5);
        Fruit fruit3 = new Fruit(3, "荔枝", new BigDecimal("9.99"), 40, 2.0);
        fruitList.add(fruit1);
        fruitList.add(fruit12);
        fruitList.add(fruit2);
        fruitList.add(fruit3);
        return fruitList;
    }

    private static void calculate() {
        List<Fruit> list = initial();
        System.out.println("求和：" + list.stream().mapToDouble(Fruit::getWeight).sum());
        System.out.println("最大：" + list.stream().mapToDouble(Fruit::getWeight).max());
        System.out.println("最小：" + list.stream().mapToDouble(Fruit::getWeight).min());
        System.out.println("平均值：" + list.stream().mapToDouble(Fruit::getWeight).average());
    }

    private static void group() {
        List<Fruit> list = initial();
        Map<Integer, List<Fruit>> groupBy = list.stream().collect(Collectors.groupingBy(Fruit::getId));
        System.out.println(groupBy);
    }

    private static void filter() {
        List<Fruit> fruitList = initial();
        List<Fruit> filterList = fruitList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());
        System.out.println(JSON.toJSON(filterList));
        List<Fruit> filterList2 = fruitList.stream().filter(a -> a.getName().equals("香蕉")).collect(Collectors.toList());
    }

    private static void extractElement() {
        List<Fruit> fruitList = initial();
        List<String> filterList = fruitList.stream().map(a -> a.getName()).collect(Collectors.toList());
        System.out.println(JSON.toJSON(filterList));
    }

    private static void findAny() {
        List<Fruit> fruitList = initial();
        Fruit fruit = fruitList.stream().filter(a -> {
            if ("荔枝".equals(a.getName())) {
                return true;
            }
            return false;
        }).findAny().orElse(null);
        System.out.println(fruit.toString());
    }

    public static void main(String[] args) {
        //calculate();
        //group();
        // filter();
        //测试anyMatch
        List<Fruit> fruitList = initial();
        //提取水果名称
        Set<String> names = fruitList.stream().map(fruit -> fruit.getName()).collect(Collectors.toSet());
        Fruit fruit = fruitList.stream().filter(f -> "荔枝".equals(f.getName())).findAny().orElse(null);
        System.out.println(fruit);
        Fruit fruit1 = new Fruit(1, "苹果1", new BigDecimal("3.25"), 10, 1.1);
        boolean b = fruitList.stream().findAny().equals(fruit1);
    }
}
