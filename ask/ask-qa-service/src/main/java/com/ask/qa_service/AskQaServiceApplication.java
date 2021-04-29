package com.ask.qa_service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@MapperScan(value = "com.ask.qa_service.dao")
@EnableEurekaClient
@SpringBootApplication
public class AskQaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AskQaServiceApplication.class, args);
    }

}
