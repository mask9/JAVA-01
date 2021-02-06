package com.dream.mask.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo_join {
    public static void main(String[] args) throws Exception{
        int a = 1;
        int b = 2;
        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(new MyRunnable(a, b, result));
        thread.start();
        thread.join();
        System.out.println(result);
    
    }
    private static int sum(int a,int b) {
        return a + b;
    }
    
    static class MyRunnable implements Runnable{
        private int a;
        private int b;
        private AtomicInteger result;
    
        public MyRunnable(int a, int b, AtomicInteger result) {
            this.a = a;
            this.b = b;
            this.result = result;
        }
    
        @Override
        public void run() {
            result.set(sum(a,b));
        }
    }
}

