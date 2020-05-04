package com.apparel.apparelstore.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {
    @Bean
    public DataSource dataSource() {
        DataSourceBuilder builder = DataSourceBuilder.create();
        // adding datasource url
        builder.url("jdbc:postgresql://localhost:5432/apparelStore");
        // we can also add username and password for datasource
        return builder.build();
    }
}