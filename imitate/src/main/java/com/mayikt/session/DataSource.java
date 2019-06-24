package com.mayikt.session;

import lombok.Data;

@Data
public class DataSource {

    private String username;

    private String password;

    private String url;

    private String driver;

    public DataSource(String username, String password, String url, String driver) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.driver = driver;
    }
}
