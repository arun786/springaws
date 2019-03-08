package com.arun.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Bean(name = "mysqlDatasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "mysqlNamedParameterJdbcTemplate")
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Qualifier("mysqlDatasource") DataSource mysqlDataSource) {
        return new NamedParameterJdbcTemplate(mysqlDataSource);
    }

    @Bean(name = "mysqlJdbcTemplate")
    public JdbcTemplate jdbcTemplate(@Qualifier("mysqlDatasource") DataSource mysqlDataSource) {
        return new JdbcTemplate(mysqlDataSource);
    }
}
