package com.mayikt.session;

import com.mayikt.mappers.UserMapper;

public interface SqlSession {

    <T> T getMapper(Class<T> type);
}
