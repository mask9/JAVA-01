package com.dream.mask.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public Student student() {
        return new Student(1, "mask", "mask");
    }
}
