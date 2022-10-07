package com.api.jitpay.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableJpaRepositories("com.api.jitpay.*")
@EnableTransactionManagement
public class PostgresqlConfiguration {

}
