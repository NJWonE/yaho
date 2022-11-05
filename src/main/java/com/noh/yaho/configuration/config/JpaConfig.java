package com.noh.yaho.configuration.config;


import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EntityScan(basePackages = {"com.noh.yaho"})
public class JpaConfig {
}
