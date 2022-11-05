package com.noh.yaho.configuration.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.noh.yaho"})
public class YahoApplication {

    public static void main(String[] args) {
        SpringApplication.run(YahoApplication.class, args);
    }

}
