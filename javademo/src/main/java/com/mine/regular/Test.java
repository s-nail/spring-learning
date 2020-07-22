package com.mine.regular;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by jiayq24996 on 2020-04-01
 */
public class Test {
    private static Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");

    public static void main(String[] args) {
        Matcher isNum = pattern.matcher("1121 2");
        System.out.println(isNum.matches());
    }
}
