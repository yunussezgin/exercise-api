package com.yunus.exerciseapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Exercise API")
                .version("v1")
                .description("Exercise API")
                .contact(new Contact().name("Yunus Sezgin").email("yunussezgin80@gmail.com")));
    }
}
