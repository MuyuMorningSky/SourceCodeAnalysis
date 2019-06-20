package com.mayikt.session;

import com.mayikt.builder.XMLConfigBuilder;

public class SqlSessionFactoryBuilder {


    /**
     * 解析配置文件
     * @param propertiesName
     * @return
     */
    public SqlSessionFactory build(String propertiesName) {
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder("my_config.properties");
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration configuration) {
        return new DefaultSqlSessionFactory(configuration);
    }
}
