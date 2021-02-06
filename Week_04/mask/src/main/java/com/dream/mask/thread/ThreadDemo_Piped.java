package com.dream.mask.thread;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

public class ThreadDemo_Piped {
    public static void main(String[] args) throws Exception{
        PipedWriter out = new PipedWriter();
        PipedReader in = new PipedReader();
        // 将输出流和输入流进行连接，否则在使用时会抛出IOException
        out.connect(in);
        int a = 1;
        int b = 2;
        int result;
        Thread thread = new Thread(new MyRunnable(a, b, out));
        thread.start();
    
        try {
            while ((result = in.read()) == -1) {
                if (result != -1) {
                    System.out.println(result);
                }
            }
        } finally {
            in.close();
        }
        System.out.println(result);
    
    }
    private static int sum(int a,int b) {
        return a + b;
    }
    
    static class MyRunnable implements Runnable{
        private int a;
        private int b;
        private PipedWriter out;
    
        public MyRunnable(int a, int b,PipedWriter out) {
            this.a = a;
            this.b = b;
            this.out = out;
        }
    
        @Override
        public void run() {
            try {
                int sum = sum(a, b);
                out.write(sum);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

