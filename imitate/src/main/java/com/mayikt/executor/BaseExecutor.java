package com.mayikt.executor;

import com.mayikt.annotation.Select;
import com.mayikt.statement.MappedStatement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseExecutor {

    private Map<String, Object> cache = new HashMap<String, Object>();

    public <T> T executor(MappedStatement mappedStatement) {
        if (mappedStatement.getSqlType() instanceof Select) {
            query(mappedStatement);
        }
        return null;
    }

    /**
     * 查询缓存数据
     * @param ms
     * @param <E>
     * @return
     */
    public <E> List<E> query(MappedStatement ms) {
        List<E> listValue = (List<E>) cache.get(ms.getMappedStatementKey());
        if (listValue != null) {
            return listValue;
        }
        // 调用数据库查询
        return queryFromDatabase(ms);
    }

    private <E> List<E> queryFromDatabase(MappedStatement ms) {
        System.out.println("调用数据查询...ms:"+ms.toString());
        List<E> list = doQuery(ms);
        if (list != null) {
            cache.put(ms.getMappedStatementKey(), list);
        }
        return list;
    }

    protected abstract <E> List<E> doQuery(MappedStatement ms);
}
