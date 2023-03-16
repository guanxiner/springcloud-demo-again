package com.atguigu.giliorder.config;

import com.atguigu.giliorder.rule.EurekaRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName: RibbonConfig
 * Package: com.atguigu.giliorder.config
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 11:55
 * @Version 1.0
 */
@SpringBootConfiguration
public class RibbonConfig {

    //重写随机分配服务规则
    @Bean
    public EurekaRule eurekaRule(){
        return new EurekaRule();
    }

//    @Bean
//    public RandomRule randomRule(){
//        return new RandomRule();
//    }

    @Bean
    @LoadBalanced //负载均衡
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
