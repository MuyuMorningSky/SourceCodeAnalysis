package com.mayikt.proxy;

import com.mayikt.entity.UserEntity;
import com.mayikt.session.SqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy<T> implements InvocationHandler {

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return new UserEntity(11, "mayikt", 222);
    }
}
