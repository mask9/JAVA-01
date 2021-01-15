package com.dream.mask.classloader;

import java.io.File;
import java.io.FileInputStream;

public class MaskClassLoader extends ClassLoader{
    public static void main(String[] args) {
        try {
            Object hello = new MaskClassLoader().findClass("Hello").newInstance();
            hello.getClass().getMethod("hello",null).invoke(hello);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = getClass().getClassLoader().getResource("").getPath();
        File file = new File(path+"Hello.xlass");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[fileInputStream.available()];
            fileInputStream.read(bytes);
            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) (255 - bytes[i]);
            }
            return defineClass(name,bytes,0,bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
