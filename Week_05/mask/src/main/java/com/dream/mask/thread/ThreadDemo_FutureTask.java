package com.dream.mask.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadDemo_FutureTask {
    public static void main(String[] args) throws Exception{
        int a = 1;
        int b = 2;
        AtomicInteger result = new AtomicInteger();
        FutureTask futureTask = new FutureTask(new MyRunnable(a, b, result));
        Thread thread = new Thread(futureTask);
        thread.start();
        if (!futureTask.isDone()) {
            System.out.println(futureTask.get());
        }
    }
    private static int sum(int a,int b) {
        return a + b;
    }
    
    static class MyRunnable implements Callable<AtomicInteger> {
        private int a;
        private int b;
        private AtomicInteger result;
    
        public MyRunnable(int a, int b, AtomicInteger result) {
            this.a = a;
            this.b = b;
            this.result = result;
        }
        @Override
        public AtomicInteger call() throws Exception {
            result.set(sum(a,b));
            return result;
        }
    }
}

