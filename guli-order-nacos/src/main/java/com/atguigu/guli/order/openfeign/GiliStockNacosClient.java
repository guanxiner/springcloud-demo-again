package com.atguigu.guli.order.openfeign;

import com.atguigu.guli.order.entity.StockEntity;
import com.atguigu.guli.order.openfeign.fallbackmethod.GiliStockNacosClientFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * ClassName: GiliStockNacosClient
 * Package: com.atguigu.guli.order.openfeign
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/18 9:56
 * @Version 1.0
 */
@FeignClient(value = "guli-stock-nacos",fallback = GiliStockNacosClientFallBack.class)
public interface GiliStockNacosClient {
    @GetMapping("/stock/{productId}/{count}")
    public Boolean updateNacosStock(@PathVariable("productId")Long productId ,@PathVariable("count") Long count);

    //测试远程调用不同参数类型
    //1.普通参数
    @GetMapping("/stock/test1")
    public String test1(@RequestParam Long productId ,@RequestParam Long count );

    //2.实体类对象
    @PostMapping("/stock/test2")
    public String test2(@RequestBody StockEntity stock);

    //3.集合类型参数
    @PostMapping("/stock/test3")
    public String test3(@RequestBody Map map);

}
