package com.mask.transaction;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mask.transaction.mapper") //设置mapper接口的扫描包
public class TransactionApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TransactionApplication.class, args);
    }
    
}
