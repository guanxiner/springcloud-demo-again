package com.atguigu.giliorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GiliOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiliOrderApplication.class, args);
    }

}
