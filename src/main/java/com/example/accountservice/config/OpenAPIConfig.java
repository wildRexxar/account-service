package com.example.accountservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${swagger.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);

        Contact contact = new Contact();
        contact.setEmail("ilya.skavysh@gmail.com");
        contact.setName("Ilya Skavysh");

        Info info = new Info()
                .title("Tutorial Management API")
                .version("1.0")
                .contact(contact);
        return new OpenAPI().info(info).servers(List.of(devServer));
    }
}