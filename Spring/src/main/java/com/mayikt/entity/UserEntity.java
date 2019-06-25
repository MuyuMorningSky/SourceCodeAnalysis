package com.mayikt.entity;

import lombok.Data;

@Data
public class UserEntity {

    private String username;

    private Integer age;

    public UserEntity(String username, Integer age) {
        this.username = username;
        this.age = age;
    }
}
