package com.atguigu.guli.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.atguigu.guli.order.entity.StockEntity;
import com.atguigu.guli.order.openfeign.GiliStockNacosClient;
import com.atguigu.guli.order.openfeign.fallbackmethod.DeadTest;
import com.atguigu.guli.order.service.OrderService;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/order")
public class OrderController {
//业务层测试调用~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Autowired
    OrderService orderService;

//测试远程访问库存服务~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @Resource
    GiliStockNacosClient giliStockNacosClient;

//测试配置中心默认，参数读取~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /*@Value("${url}")
    private String url;
    @Value("${username}")
    private String username;*/

//测试配置中心自定义，参数读取~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   /* @Value("${mysql.url}")
    private String mysqlUrl;
    @Value("${mysql.driver-class-name}")
    private String mysqlDriverClassName;
    @Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private String redisPort;
    //自定义分组
    @Value("${ngix.host}")
    private String ngixHost;
    @Value("${ngix.port}")
    private String ngixPort;  */

//测试配置中心自定义名称空间，参数读取~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /*
    @Value("${guli.host}")
    private String guliHost;
    @Value("${guli.port}")
    private String guliPort;
    */

//测试热点key熔断规则~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @GetMapping("/test")
    @SentinelResource(value = "testResource",blockHandler = "deadTest",blockHandlerClass = DeadTest.class)
    public String test(@RequestParam(value = "pid",required = false)Long pid,
                       @RequestParam(value = "count",required = false)Long count){
        System.out.println("购买商品的id为："+pid+" , 数量："+count);
        return "test";
    }

//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    @GetMapping("/{userId}/{productId}/{count}")
    public Boolean createOrder(@PathVariable("userId")Long userId,
                               @PathVariable("productId")Long productId,
                               @PathVariable("count")Long count){
        //输出默认配置参数读取
        /*System.out.println("url:"+url+",username:"+username);
        //测试自定义配置参数读取
        System.out.println("mysql:"+mysqlUrl+",mysqlDriverClassName:"+mysqlDriverClassName);
        System.out.println("redis:"+redisPort+",redisHost:"+redisHost);
        System.out.println("ngix:"+ngixPort+",ngixHost:"+ngixHost);
        System.out.println("guli:"+guliPort+",guliHost:"+guliHost);*/


//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //测试不同参数传递
/*
        giliStockNacosClient.test1(1234l,1234l);

        StockEntity stock = new StockEntity();
        stock.setCount(4567l);
        stock.setProductId(4567l);
        giliStockNacosClient.test2(stock);

        Map map = new HashMap();
        map.put("stock",8945);
        map.put("order",8945);
        giliStockNacosClient.test3(map);

 */

        //return true;
        return orderService.saveOrder(userId,productId,count);
    }
}
