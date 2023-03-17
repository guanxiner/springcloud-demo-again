//package com.atguigu.guli.gateway.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.RequestPath;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.util.AntPathMatcher;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * ClassName: GiliGlobalFilter
// * Package: com.atguigu.guli.gateway.filter
// * Description:
// *
// * @Author 王宝民
// * @Create 2023/3/17 20:01
// * @Version 1.0
// */
//@Component
//public class GiliGlobalFilter implements GlobalFilter , Ordered {
//    //全局过滤器
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        //从交换机中获取请求路径信息
//        ServerHttpRequest request = exchange.getRequest();
//        //RequestPath path1 = request.getPath();
//        //String s = path1.toString();
//        //System.out.println(s);
//        System.out.println("request.getPath()是："+request.getPath());
//        String path = request.getURI().getPath();
//        //boolean b = s==path;
//        //boolean b1 = s.equals(path);
//        //System.out.println(b);//true
//        //System.out.println(b1);//true
//        AntPathMatcher antPathMatcher = new AntPathMatcher();
//        //判断路径是否含有“order”,有就放行交给目标任务
//        boolean flag = antPathMatcher.match("/order/**", path);
//        System.out.println(path);
//        System.out.println(request.getHeaders().getFirst("Host"));
//        if (flag){
//            return chain.filter(exchange);
//        }
//        //不存在就响应给前端错误信息
//        ServerHttpResponse response = exchange.getResponse();
//        response.setStatusCode(HttpStatus.BAD_GATEWAY);
//        return response.setComplete();
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
