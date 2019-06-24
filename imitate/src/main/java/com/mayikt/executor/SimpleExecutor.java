package com.mayikt.executor;

import com.mayikt.session.Configuration;
import com.mayikt.session.DataSource;
import com.mayikt.statement.MappedStatement;
import com.mayikt.utils.MyBatisJDBCUtil;

import java.util.List;

public class SimpleExecutor extends BaseExecutor{

    @Override
    protected <E> List<E> doQuery(MappedStatement ms) {
        Configuration configuration = ms.getConfiguration();
        // 获取dataSource数据相关配置
        DataSource dataSource = configuration.getDataSource();
        MyBatisJDBCUtil myBatisJDBCUtil = new MyBatisJDBCUtil(dataSource);
        List<E> objects = (List<E>) myBatisJDBCUtil.queryListExecute(ms.getSqlValue(), ms.getArgs(), ms.getResultType());
        return objects;
    }
}
