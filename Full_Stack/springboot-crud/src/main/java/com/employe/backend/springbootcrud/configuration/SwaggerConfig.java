package com.employe.backend.springbootcrud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket actionSwaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2).groupName("Employee Management System").tags(
                new Tag("Employee Api", "Repository for Employees ")
        )
                .apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.employe.backend.springbootcrud")).
                        paths(regex("/.*")).build().pathMapping("/");

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Employee Module")
                .description("Swagger Integration EMS")
                .termsOfServiceUrl(null)
                .license(null)
                .licenseUrl(null).version("1.0").build();
    }
}
