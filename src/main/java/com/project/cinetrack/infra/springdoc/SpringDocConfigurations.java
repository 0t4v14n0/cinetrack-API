package com.project.cinetrack.infra.springdoc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SpringDocConfigurations {
	
	@Bean
	 public OpenAPI customOpenAPI() {
	   return new OpenAPI()
	          .components(new Components()
	          .addSecuritySchemes("bearer-key",
	          new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")))
             .info(new Info()
                     .title("CineTrack API")
                     .description("CineTrack é um sistema de gerenciamento e avaliação de séries e filmes, "
                     		+ "com funcionalidades para cadastro de usuários, gerenciamento de favoritos, "
                     		+ "revisão de conteúdos e interação social através de um sistema de amigos e chat"
                     		+ " em tempo real.")
                     .contact(new Contact()
                             .name("Otaviano")
                             .email("0t4v14n0@gmail.com"))
             .license(new License()
                     .name("GitHub")
                     .url("https://github.com/0t4v14n0/cinetrack-API")));
	}

}
