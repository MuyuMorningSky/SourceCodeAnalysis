package com.mayikt.session;

import com.mayikt.proxy.MapperProxyFactory;

public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;

    public DefaultSqlSession(Configuration configuration) {
        this.configuration = configuration;
    }

    public <T> T getMapper(Class<T> type) {
        // 1.查询configuration 是否有注册该Mapper接口
        MapperProxyFactory mapperProxyFactory = (MapperProxyFactory) configuration.getMapper(type);
        if (mapperProxyFactory == null) {
            try {
                throw new Exception("Type " + type + " is not known to the MapperRegistry.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return (T) mapperProxyFactory.newInstance(this);
    }
}
