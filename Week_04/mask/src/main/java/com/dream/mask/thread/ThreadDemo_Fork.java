package com.dream.mask.thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class ThreadDemo_Fork {
    public static void main(String[] args) throws Exception{
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MyTask task = new MyTask(1, 2);
        // 执行一个任务
        Future<Integer> result = forkJoinPool.submit(task);
        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
        
        }
    
    }
    private static int sum(int a,int b) {
        return a + b;
    }
    static class MyTask extends RecursiveTask<Integer>{
    
        private int a;
        private int b;
    
        public MyTask(int a, int b) {
            this.a = a;
            this.b = b;
        }
    
        @Override
        protected Integer compute() {
            //一个计算任务，不需要Fork子任务
            return sum(a,b);
        }
    }
}

