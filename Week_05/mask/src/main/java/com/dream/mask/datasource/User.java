package com.dream.mask.datasource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    
    private int id;
    private String userName;
    private String sex;
    private int age;
    
    public User(String userName, String sex, int age) {
        this.userName = userName;
        this.sex = sex;
        this.age = age;
    }
}
