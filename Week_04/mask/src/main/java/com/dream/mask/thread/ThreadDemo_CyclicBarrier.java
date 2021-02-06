package com.dream.mask.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo_CyclicBarrier {
    public static void main(String[] args) throws Exception{
        int a = 1;
        int b = 2;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        AtomicInteger result = new AtomicInteger();
        Thread thread = new Thread(new MyRunnable(a, b, result,cyclicBarrier));
        thread.start();
        cyclicBarrier.await();
        System.out.println(result);
        
    }
    private static int sum(int a,int b) {
        return a + b;
    }
    
    static class MyRunnable implements Runnable{
        private int a;
        private int b;
        private AtomicInteger result;
        private CyclicBarrier cyclicBarrier ;
        
        public MyRunnable(int a, int b, AtomicInteger result,CyclicBarrier cyclicBarrier ) {
            this.a = a;
            this.b = b;
            this.result = result;
            this.cyclicBarrier = cyclicBarrier;
        }
        
        @Override
        public void run() {
            result.set(sum(a,b));
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}

