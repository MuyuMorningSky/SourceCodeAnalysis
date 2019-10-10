package com.mayikt.session;

import com.mayikt.statement.MappedStatement;

public interface SqlSession {

    <T> T getMapper(Class<T> type);

    <T> T selectOne(MappedStatement mappedStatement);
}
