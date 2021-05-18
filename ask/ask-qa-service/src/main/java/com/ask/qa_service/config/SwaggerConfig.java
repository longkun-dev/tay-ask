package com.ask.qa_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2配置类
 *
 * @author zhulongkun20@163.com
 * @since 2021/5/15 13:40
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .pathMapping("/")
                .select()
                .paths(PathSelectors.any())
                .build()
                .apiInfo(new ApiInfoBuilder()
                        .title("tay ask")
                        .description("一个基于SpringCloud的简易在线问答平台")
                        .version("1.0")
                        .contact(new Contact("ice-demo",
                                "https://iced-cola.com",
                                "zhulongkun20@gmail.com")
                        )
                        .license("MIT License")
                        .licenseUrl("https://baidu.com")
                        .build());
    }
}
