package com.arun.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "awsEntityManagerFactory",
        basePackages = {"com.arun.jpa"}
)
public class AwsDatabaseConfig {

    @Primary
    @Bean(name = "awsDatasourceForJPA")
    @ConfigurationProperties(prefix = "aws.datasource")
    public DataSource awsDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "awsEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean awsEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("awsDatasourceForJPA") DataSource awsDataSource) {
        return builder.dataSource(awsDataSource).packages("com.arun.model").persistenceUnit("customer").persistenceUnit("item").build();
    }

    @Primary
    @Bean(name = "awsTransactionManager")
    public PlatformTransactionManager awsTransactionManager(@Qualifier("awsEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(entityManagerFactory);
        return jpaTransactionManager;
    }

}
