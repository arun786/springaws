package com.arun.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LocalDatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "local.datasource")
    public DataSource localDataSource() {
        return DataSourceBuilder.create().build();
    }
}
