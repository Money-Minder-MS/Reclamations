package com.Examen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients    // Permet la communication via Feign avec les autres microservices
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}