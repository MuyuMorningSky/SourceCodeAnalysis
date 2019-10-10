package com.mayikt.statement;

import com.mayikt.annotation.Select;
import com.mayikt.session.Configuration;
import lombok.Data;

import java.lang.annotation.Annotation;

@Data
public class MappedStatement {
    /**
     * 配置文件
     */
    private Configuration configuration;
    /**
     * sql 语句
     */
    private String sqlValue;
    /**
     * sql 类型
     */
    private Annotation sqlType;
    /**
     * 参数
     */
    private Object[] args;
    /**
     * 返回类型
     */
    private Class<?> resultType;

    public MappedStatement(Annotation sqlType, Class<?> resultType, Object[] args) {
        this.sqlType = sqlType;
        this.resultType = resultType;
        this.args = args;
        getSqlValue(sqlType);
    }

    /**
     * 获取sql语句
     * @param sqlType
     */
    public void getSqlValue(Annotation sqlType) {
        if (sqlType instanceof Select) {
            Select select = (Select) sqlType;
            sqlValue = select.value();
        }
    }

    /**
     * 获取注解类型
     * @return
     */
    public Select getSelectAnnotation() {
        if (sqlType instanceof Select) {
            Select select = (Select) sqlType;
            return select;
        }
        return null;
    }

    /**
     * mapper命名空间+id
     * @return
     */
    public String getMappedStatementKey() {
        String mappedStatementKey = sqlValue + arrayToString() + resultType.toString();
        return mappedStatementKey;
    }

    public String arrayToString() {
        String str = "";
        for (int i = 0; i < args.length; i++) {
            Object obj = (Object) args[i];
            str += obj + "";
        }
        return str;
    }

}
