package com.mayikt.session;

import com.mayikt.builder.XMLConfigBuilder;

public class SqlSessionFactoryBuilder {


    /**
     * 解析配置文件
     * @param propertiesName
     * @return
     */
    public SqlSessionFactory build(String propertiesName) {
        /**
         * 读取配置文件
         */
        XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder("my_config.properties");
        /**
         * 解析配置文件
         */
        return build(xmlConfigBuilder.parse());
    }

    public SqlSessionFactory build(Configuration configuration) {
        //传递configuration配置
        return new DefaultSqlSessionFactory(configuration);
    }
}
