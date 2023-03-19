package com.atguigu.guli.order;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class GuliOrderNacosApplication {
    public static void main(String[] args) {
        SpringApplication.run(GuliOrderNacosApplication.class,args);
    }

    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }
}
