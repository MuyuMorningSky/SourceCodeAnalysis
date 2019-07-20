package com.mayikt.service;

import org.junit.Test;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


@Service
@Lazy(value = true)
@Scope("prototype")
public class UserService {

    public UserService(){
        System.out.println(">>>>>>>>>>>>>>无参构造函数被执行");
    }

    public void testAsync() {

    }
}
