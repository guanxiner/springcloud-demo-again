package com.atguigu.guli.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.UUID;

/**
 * ClassName: GuliAddTokenGatewayFilterFactory
 * Package: com.atguigu.guli.gateway.filter
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/17 20:35
 * @Version 1.0
 */
@Component
public class GuliAddTokenGatewayFilterFactory extends AbstractGatewayFilterFactory {

    @Override
    public GatewayFilter apply(Object config) {
        return new GatewayFilter() {
            @Override
            public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
                ServerHttpRequest request = exchange.getRequest();
                String path = request.getURI().getPath();
                System.out.println(path);
                //在请求头中设置一个cokie
                //request.mutate().header("cookie", "token="+UUID.randomUUID().toString().replaceFirst("-", "")).build();
                request.mutate().header("cookie","token="+UUID.randomUUID().toString().replace("-","")).build();
                exchange.mutate().request(request).build();
                return chain.filter(exchange);
            }
        };
    }

    @Override
    public String name() {

        return "guliAdd";
    }
}
