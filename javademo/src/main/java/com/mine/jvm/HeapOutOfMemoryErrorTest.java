package com.mine.jvm;

import java.util.*;

/**
 * java 堆内存溢出
 * <p>
 * VM Args: -Xms4m -Xmx4m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=D:\aa.dump -XX:+PrintGCDetails
 *
 * @author yuhao.wang3
 * @since 2019/11/30 17:09
 */
public class HeapOutOfMemoryErrorTest {
    public static void main(String[] args) throws InterruptedException {
        try {

            // 模拟大容器
            List<Object> list = new ArrayList<>();
            for (long i = 1; i > 0; i++) {
                list.add(new Object());
                if (i % 100_000 == 0) {
                    System.out.println(Thread.currentThread().getName() + "::" + i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}