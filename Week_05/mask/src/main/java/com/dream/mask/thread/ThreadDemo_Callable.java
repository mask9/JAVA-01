package com.dream.mask.thread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadDemo_Callable {
    
    public static void main(String[] args) throws Exception{
        int a = 1;
        int b = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> submit = executorService.submit(() -> sum(a, b));
        Integer integer = submit.get();
        System.out.println(integer);
        executorService.shutdown();
    }
    private static int sum(int a,int b) {
        return a + b;
    }
}
