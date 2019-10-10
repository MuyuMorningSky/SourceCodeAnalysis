package com.mayikt.proxy;

import com.mayikt.session.SqlSession;

import java.lang.reflect.Proxy;

public class MapperProxyFactory<T> {

    private Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 生成mapperProxy对象
     * @param sqlSession
     * @return
     */
    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<T>(sqlSession, mapperInterface);
        return newInstance(mapperProxy);
    }

    /**
     * 生成代理类
     * @param mapperProxy
     * @return
     */
    protected T newInstance(MapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[] { mapperInterface }, mapperProxy);
    }
}
