package com.mine.concurrent.semaphore;

import java.util.concurrent.Semaphore;

public class PrintABCUsingSemaphore {
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public static void main(String[] args) {
        new PrintA(semaphoreA,semaphoreB).start();
        new PrintB(semaphoreB,semaphoreC).start();
        new PrintC(semaphoreC,semaphoreA).start();
    }

    static class PrintA extends Thread {
        private Semaphore current;
        private Semaphore next;

        private PrintA(Semaphore current, Semaphore next) {
            this.current = current;
            this.next = next;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    current.acquire();
                    System.out.print("A");
                    next.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class PrintB extends Thread {
        private Semaphore current;
        private Semaphore next;

        private PrintB(Semaphore current, Semaphore next) {
            this.current = current;
            this.next = next;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    current.acquire();
                    System.out.print("B");
                    next.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class PrintC extends Thread {
        private Semaphore current;
        private Semaphore next;

        private PrintC(Semaphore current, Semaphore next) {
            this.current = current;
            this.next = next;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    current.acquire();
                    System.out.print("C");
                    next.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}