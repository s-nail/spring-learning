package com.mine.spi;

import java.util.ServiceLoader;

/**
 * Created by jiayq24996 on 2020-05-28
 */
public class SPITest {
    public static void main(String[] args) {
        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
        for (IShout s : shouts) {
            s.shout();
        }
    }
}
