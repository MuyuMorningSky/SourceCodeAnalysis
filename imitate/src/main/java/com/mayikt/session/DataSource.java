package com.mayikt.session;

public class DataSource {

    private String userName;

    private String password;

    private String url;

    private String driver;

    public DataSource(String userName, String password, String url, String driver) {
        this.userName = userName;
        this.password = password;
        this.url = url;
        this.driver = driver;
    }
}
