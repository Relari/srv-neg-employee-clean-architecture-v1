package com.pe.relari.infrastructure.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <b>Class:</b> SwaggerConfig.</br>
 * @author Renzo Lavado Rivas.
 * @version 1.0.0
 */

@Lazy
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Value("${application.info.project.title}")
  private String appTitle;

  @Value("${application.info.project.version}")
  private String appVersion;

  @Value("${application.info.project.description}")
  private String appDescription;

  @Bean
  public Docket api() {
    return new Docket(DocumentationType.SWAGGER_2)
        .apiInfo(apiInfo())
        .select()
        .paths(PathSelectors.any())
        .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
        .build()
        .useDefaultResponseMessages(false);
  }

  private ApiInfo apiInfo() {
    return new ApiInfo(
            appTitle,
            appDescription,
            appVersion,
            "https://github.com/Relari/Employee",
            new Contact(
                    "Renzo Daniel Lavado Rivas",
                    "https://github.com/Relari",
                    "renzolavador@gmail.com"
            ),
            "Employee License",
            "https://github.com/Relari/Employee",
            Collections.emptyList()
    );
  }
}
