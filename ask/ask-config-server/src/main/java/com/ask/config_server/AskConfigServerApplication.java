package com.ask.config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableDiscoveryClient
@EnableConfigServer
@SpringBootApplication
public class AskConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AskConfigServerApplication.class, args);
    }

}
