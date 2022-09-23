package com.md.editor.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class AppConfig {

    @Bean
    public DataSource getDataSource() {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        simpleDriverDataSource.setDriverClass(com.mysql.cj.jdbc.Driver.class);
        simpleDriverDataSource.setUrl("jdbc:mysql://localhost:3306/markdown_db");
        simpleDriverDataSource.setUsername("root");
        return simpleDriverDataSource;
    }

}