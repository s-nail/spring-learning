package com.mine.concurrent.semaphore;

import java.util.concurrent.Semaphore;

/**
 * 三个线程，依次打印：ABCABCABC
 * Created by jiayq24996 on 2020-08-19
 */
public class PrintABCABCABC {

    private static volatile int flag = 1;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);

        new PrintC(semaphore).start();
        new PrintB(semaphore).start();
        new PrintA(semaphore).start();
    }

    static class PrintA extends Thread {
        private Semaphore semaphore;

        private PrintA(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            while (true) {
                if (PrintABCABCABC.flag == 1) {
                    try {
                        semaphore.acquire();
                        System.out.print("A");
                        semaphore.release();
                        PrintABCABCABC.flag = 2;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class PrintB extends Thread {
        private Semaphore semaphore;

        private PrintB(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            while (true) {
                if (PrintABCABCABC.flag == 2) {
                    try {
                        semaphore.acquire();
                        System.out.print("B");
                        semaphore.release();
                        PrintABCABCABC.flag = 3;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class PrintC extends Thread {
        private Semaphore semaphore;

        private PrintC(Semaphore semaphore) {
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            while (true) {
                if (PrintABCABCABC.flag == 3) {
                    try {
                        semaphore.acquire();
                        System.out.print("C");
                        semaphore.release();
                        PrintABCABCABC.flag = 1;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
