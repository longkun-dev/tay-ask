package com.ask.qa_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@MapperScan(value = "com.ask.qa_service.dao")
@EnableEurekaClient
@SpringBootApplication
public class AskQaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AskQaServiceApplication.class, args);
    }

}
