package com.dream.mask.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutowiredConfigDemo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.dream.mask.spring");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
}
