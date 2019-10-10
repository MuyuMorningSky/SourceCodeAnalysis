package com.mayikt.proxy;

import com.mayikt.annotation.Select;
import com.mayikt.session.SqlSession;
import com.mayikt.statement.MappedStatement;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxy<T> implements InvocationHandler {

    private Class<T> mapperInterface;

    private SqlSession sqlSession;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        MappedStatement mappedStatement = getMappedStatement(method, args);
        return execute(mappedStatement);
    }

    private Object execute(MappedStatement mappedStatement) {
        if (mappedStatement.getSqlType() instanceof Select) {
            return sqlSession.selectOne(mappedStatement);
        }
        return null;
    }

    /**
     * 获取mappedStatement/ mapper.xml
     *
     * @param method
     * @param args
     * @return
     */
    private MappedStatement getMappedStatement(Method method, Object[] args) {
        Select selectAnnotation = method.getAnnotation(Select.class);
        if (selectAnnotation == null) {
            return null;
        }
        MappedStatement mappedStatement = new MappedStatement(selectAnnotation, method.getReturnType(), args);
        return mappedStatement;
    }


}
