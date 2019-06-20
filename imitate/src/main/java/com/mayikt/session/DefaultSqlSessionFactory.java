package com.mayikt.session;

public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final Configuration configuration;

    public DefaultSqlSessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    public SqlSession openSqlSession() {
        // 只用默认的sqlSqlSession
        return new DefaultSqlSession(configuration);
    }
}
