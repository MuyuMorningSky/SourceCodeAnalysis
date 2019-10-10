package com.mayikt.session;

import com.mayikt.executor.BaseExecutor;
import com.mayikt.proxy.MapperProxyFactory;
import com.mayikt.statement.MappedStatement;

import java.util.List;

public class DefaultSqlSession implements SqlSession {

    private final Configuration configuration;

    private BaseExecutor baseExecutor;

    public DefaultSqlSession(Configuration configuration, BaseExecutor baseExecutor) {
        this.baseExecutor = baseExecutor;
        this.configuration = configuration;
    }

    /**
     * 获取代理类
     * @param type
     * @param <T>
     * @return
     */
    public <T> T getMapper(Class<T> type) {
        // 1.获取Mapper接口
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

    public <T> T selectOne(MappedStatement statement) {
        List<T> list = this.selectList(statement);
        if (list.size() == 1) {
            return list.get(0);
        } else if (list.size() > 1) {
            return (T) list;
        } else {
            return null;
        }
    }

    public <T> List<T> selectList(MappedStatement statement) {
        statement.setConfiguration(configuration);
        return baseExecutor.query(statement);
    }
}
