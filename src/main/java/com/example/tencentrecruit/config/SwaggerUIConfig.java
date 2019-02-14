package com.example.tencentrecruit.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

/**
 * Function:SwaggerUI Test接口的配置类
 *
 * @author liubing
 * Date: 2018/9/30 下午2:22
 * @since JDK 1.8
 */
@Configuration
@EnableSwagger2
public class SwaggerUIConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.tencentrecruit"))
                .paths(PathSelectors.any())
                .build()
                .securitySchemes(
                        Arrays.asList(new ApiKey("Authorization", "access_token", "header"))
                );
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("tencentrecruit").version("1.0.0").build();
    }
}
