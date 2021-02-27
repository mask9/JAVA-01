package com.dream.mask.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
public class ThreadDemo_CountDownLatch {
    public static void main(String[] args) throws Exception{
        int a = 1;
        int b = 2;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(new MyRunnable(a, b, result,countDownLatch));
        thread.start();
        countDownLatch.await();
        System.out.println(result);
        
    }
    private static int sum(int a,int b) {
        return a + b;
    }
    
    static class MyRunnable implements Runnable{
        private int a;
        private int b;
        private AtomicInteger result;
        private CountDownLatch countDownLatch;
        
        public MyRunnable(int a, int b, AtomicInteger result,CountDownLatch countDownLatch) {
            this.a = a;
            this.b = b;
            this.result = result;
            this.countDownLatch = countDownLatch;
        }
        
        @Override
        public void run() {
            result.set(sum(a,b));
            countDownLatch.countDown();
        }
    }
}

