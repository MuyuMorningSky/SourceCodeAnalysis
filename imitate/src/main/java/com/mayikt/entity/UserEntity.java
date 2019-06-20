package com.mayikt.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Integer id;

    private String name;

    private Integer age;

    public UserEntity(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
