package com.dream.mask.thread;

import java.util.concurrent.CompletableFuture;

public class ThreadDemo_CompletableFuture {
    public static void main(String[] args) throws Exception{
        int a = 1;
        int b = 2;
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> sum(a, b));
        System.out.println(completableFuture.get());
    
    }
    private static int sum(int a,int b) {
        return a + b;
    }
}

