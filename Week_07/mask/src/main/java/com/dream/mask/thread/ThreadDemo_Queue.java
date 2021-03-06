package com.dream.mask.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo_Queue {
    
    private static final BlockingQueue BLOCKING_QUEUE = new LinkedBlockingQueue(1);
    
    public static void main(String[] args) throws Exception{
        int a = 1;
        int b = 2;
        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(new MyRunnable(a, b, result));
        thread.start();
        while (true) {
            Object take = BLOCKING_QUEUE.take();
            System.out.println(take);
            return;
        }
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
            BLOCKING_QUEUE.add(result);
        }
    }
}

