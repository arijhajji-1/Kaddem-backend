package com.example.demo.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sound.sampled.Line;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(infoAPI());

    }
    public Info infoAPI() {
        return new Info().title("SpringDoc-Demo")
                .description("TP étude de cas")
                .contact(contactAPI());

    }
    public Contact contactAPI() {
        Contact contact = new Contact().name("Equipe ASI II")

                .email("asma.benboubaker@esprit.tn")
                .url("https://www.linkedin.com/in");
        return contact;
    }

    @Bean
    public GroupedOpenApi productPublicApi() {
        return GroupedOpenApi.builder()
                .group("Only student Management API")

                                .pathsToMatch("/etudiant/all","/etudiant/add","/etudiant/get/{id-etudiant}","/etudiant/update","/etudiant/remove/{id-etudiant}","/etudiant/addparasso/{idContrat}/{idEquipe}","/etudiant/affectContratToEtudiant/{nom}/{prenom}")
                                .pathsToExclude("**")
                                .build();
    }

    }