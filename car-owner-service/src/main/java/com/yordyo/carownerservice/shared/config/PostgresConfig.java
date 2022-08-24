package com.yordyo.carownerservice.shared.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@Profile("prod")
public class PostgresConfig {
  private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";

  @Value("${DB_URL:${spring.datasource.url}}")
  private String dbUrl;

  @Value("${DB_USERNAME:${spring.datasource.username}}")
  private String dbUsername;

  @Value("${DB_PASSWORD:${spring.datasource.password}}")
  private String dbPassword;

  @Bean
  public DataSource getPostgresDataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(DRIVER_CLASS_NAME);
    dataSource.setUrl(dbUrl);
    dataSource.setUsername(dbUsername);
    dataSource.setPassword(dbPassword);

    return dataSource;
  }
}
