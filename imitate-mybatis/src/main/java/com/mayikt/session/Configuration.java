package com.mayikt.session;

import com.mayikt.proxy.MapperProxyFactory;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Configuration {

    private DataSource dataSource;

    private String mappers;

    Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<Class<?>, MapperProxyFactory<?>>();

    public <T> void addMapper(Class<T> type) {
        knownMappers.put(type, new MapperProxyFactory<T>(type));
    }

    public <T> T getMapper(Class<T> type) {
        MapperProxyFactory<?> mapperProxyFactory = knownMappers.get(type);
        return (T) mapperProxyFactory;
    }
}
