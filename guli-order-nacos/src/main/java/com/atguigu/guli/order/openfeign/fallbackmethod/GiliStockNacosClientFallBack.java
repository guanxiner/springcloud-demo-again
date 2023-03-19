package com.atguigu.guli.order.openfeign.fallbackmethod;

import com.atguigu.guli.order.entity.StockEntity;
import com.atguigu.guli.order.openfeign.GiliStockNacosClient;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * ClassName: GiliStockNacosClientFallBack
 * Package: com.atguigu.guli.order.openfeign.fallbackmethod
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/19 16:41
 * @Version 1.0
 */
@Component
public class GiliStockNacosClientFallBack implements GiliStockNacosClient {
    @Override
    public Boolean updateNacosStock(Long productId, Long count) {
        System.out.println("updateNacosStock------>进入熔断降级！");
        return false;
    }

    @Override
    public String test1(Long productId, Long count) {
        System.out.println("test1------>进入熔断降级！");
        return "false";
    }

    @Override
    public String test2(StockEntity stock) {
        System.out.println("test2------>进入熔断降级！");
        return "false";
    }

    @Override
    public String test3(Map map) {
        System.out.println("test3------>进入熔断降级！");
        return "false";
    }
}
