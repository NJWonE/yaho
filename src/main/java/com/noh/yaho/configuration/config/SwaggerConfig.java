package com.noh.yaho.configuration.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi projectAPI(){
        return GroupedOpenApi.builder()
                .group("v1")
                .packagesToScan("com.noh.yaho")
                .build();
    }
    @Bean
    public OpenAPI OpenAPI(){
        return new OpenAPI().info(new Info().title("Yaho Project API 명세서")
                .description("메타버스 yaho 융합프로젝트 API 명세서 입니다.")
                .version("1.0"));
    }
}
