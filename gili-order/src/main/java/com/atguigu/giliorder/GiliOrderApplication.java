package com.atguigu.giliorder;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient //Eureka注册中心
@EnableFeignClients //开启远程调用
@EnableCircuitBreaker //开启hystrix熔断降级框架启动断路器
@EnableHystrixDashboard //开启熔断器监控面板
public class GiliOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(GiliOrderApplication.class, args);
    }

    @Bean
    public Logger.Level level(){
        //Full代表输出远程访问的日志为所有，输出日志级别在yml文件中配置debug级别
        return Logger.Level.FULL;
    }

    @Bean
    public ServletRegistrationBean getServlet() {
        HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
        registrationBean.setLoadOnStartup(1);
        registrationBean.addUrlMappings("/hystrix.stream");
        registrationBean.setName("HystrixMetricsStreamServlet");
        return registrationBean;
    }
}
