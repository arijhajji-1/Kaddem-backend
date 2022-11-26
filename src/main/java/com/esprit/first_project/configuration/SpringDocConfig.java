package com.esprit.first_project.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder().group("Only Product ManagementAPI")
                                .pathsToMatch("/api/**")
                                .pathsToExclude("**")
                                .build();

    }
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI().info(infoAPI());

    }
    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());

    }
    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASIII").email("oumima.ayach@esprit.tn")
                .url("https://www.linkedin.com/in/oumayma-ayachi-52714816a/");
        return contact;
    }
}
