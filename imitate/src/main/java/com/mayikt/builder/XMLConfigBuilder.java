package com.mayikt.builder;

import com.mayikt.session.Configuration;
import com.mayikt.session.DataSource;
import com.mayikt.utils.ClassUtil;
import com.mayikt.utils.PropertiesUtil;

import java.util.List;

public class XMLConfigBuilder extends BaseBuilder{

    private String propertiesName;

    private PropertiesUtil propertiesUtil;


    public XMLConfigBuilder(String properiesName) {
        this.propertiesName = properiesName;
        this.propertiesUtil = new PropertiesUtil(properiesName);
        this.configuration = new Configuration();
    }

    public Configuration parse() {
        //1. 数据源配置
        propertiesDataSource();
        //2. mapper接口配置
        propertieMappers();
        return this.configuration;
    }

    /**
     * 解析数据库连接配置文件
     */
    private void propertiesDataSource() {
        String username = propertiesUtil.readProperty("jdbc.username");
        String password = propertiesUtil.readProperty("jdbc.password");
        String url = propertiesUtil.readProperty("jdbc.url");
        String driver = propertiesUtil.readProperty("jdbc.driver");
        DataSource dataSource = new DataSource(username, password, url, driver);
        this.configuration.setDataSource(dataSource);
    }

    private void propertieMappers(){
        String mappers = propertiesUtil.readProperty("mappers");
        this.configuration.setMappers(mappers);
        //装配mappers包下接口
        List<Class<?>> classSet = ClassUtil.getClassSet(mappers);
        for (int i = 0; i < classSet.size(); i++) {
            Class<?> classInfo = classSet.get(i);
            //注册knownMapper
            configuration.addMapper(classInfo);
        }
    }

}
