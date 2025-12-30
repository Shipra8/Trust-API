package com.example.lender.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Trust API")
                        .description(" A secure microlending REST API with credit score generation")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Shipra")
                                .email("ernestshipra@gmail.com"))
                        .license(new License().name("Apache 2.0")));
    }
}
