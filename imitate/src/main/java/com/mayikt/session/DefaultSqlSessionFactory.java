package com.mayikt.session;

import com.mayikt.executor.SimpleExecutor;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    //开启会话，初始化执行器
    public SqlSession openSqlSession() {
        SimpleExecutor simpleExecutor = new SimpleExecutor();
        return new DefaultSqlSession(configuration, simpleExecutor);
    }
}
