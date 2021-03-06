package com.dream.mask.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ThreadDemo_LockSupport {
    public static void main(String[] args) throws Exception{
        int a = 1;
        int b = 2;
        AtomicInteger result = new AtomicInteger();
        Thread main = Thread.currentThread();
        Thread thread = new Thread(new MyRunnable(a, b, result,main));
        thread.start();
        LockSupport.park();
        System.out.println(result);
    
    }
    private static int sum(int a,int b) {
        return a + b;
    }
    
    static class MyRunnable implements Runnable{
        private int a;
        private int b;
        private AtomicInteger result;
    
        private Thread main;
    
        public MyRunnable(int a, int b, AtomicInteger result, Thread main) {
            this.a = a;
            this.b = b;
            this.result = result;
            this.main = main;
        }
    
        @Override
        public void run() {
            result.set(sum(a,b));
            LockSupport.unpark(main);
        }
    }
}

