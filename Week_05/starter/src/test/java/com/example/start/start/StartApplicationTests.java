package com.example.start.start;

import bean.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StartApplicationTests {
    
    @Autowired
    private Student student;
    @Test
    void contextLoads() {
        System.out.println(student.toString());
    }
    
}
