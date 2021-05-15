package com.ask.qa_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author zhulongkun20@163.com
 * @since 2021/5/15 10:22 PM
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("焦一平", "http://iced-cola.com/",
                "zhulongkun20@gmail.com");
        return new ApiInfoBuilder()
                .title("api接口")
                .description("问题接口api")
                .contact(contact)
                .version("V1.0")
                .build();
    }
}
