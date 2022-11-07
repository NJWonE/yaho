package com.noh.yaho.configuration.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = {"com.noh.yaho"})
@EnableJpaRepositories(basePackages = {"com.noh.yaho"})
public class JpaConfig {
}
