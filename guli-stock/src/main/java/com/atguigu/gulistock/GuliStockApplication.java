package com.atguigu.gulistock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GuliStockApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuliStockApplication.class, args);
    }

}
