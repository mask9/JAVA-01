package com.dream.mask.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlDemo {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/springApplication.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student);
    }
    
}
