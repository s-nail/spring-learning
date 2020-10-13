package com.mine.waitnotify;

public class OutputThread implements Runnable {
    
        private int num;
        private Object lock;
    
        public OutputThread(int num, Object lock) {
            super();
            this.num = num;
            this.lock = lock;
        }
    
        @Override
        public void run() {
            try {
                while(true){
                    synchronized(lock){
                          lock.notifyAll();//如果此处先wait,在notify不会打印任何结果
                        lock.wait();
                        Thread.sleep(1000);
                        System.out.println(num);
                    }
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
    
        }
    
        public static void main(String[] args){
            final Object lock = new Object();
    
            Thread thread1 = new Thread(new OutputThread(1, lock));
            Thread thread2 = new Thread(new OutputThread(2, lock));
    
            thread1.start();
            thread2.start();
        }
    
    }