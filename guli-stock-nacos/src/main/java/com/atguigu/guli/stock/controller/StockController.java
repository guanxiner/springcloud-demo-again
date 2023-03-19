package com.atguigu.guli.stock.controller;

import com.atguigu.guli.stock.entity.StockEntity;
import com.atguigu.guli.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Value("${server.port}")
    private Integer port;
    @Autowired
    StockService stockService;
    @GetMapping("/{productId}/{count}")
    public Boolean updateStock(@PathVariable("productId")Long productId ,
                               @PathVariable("count") Long count){
        System.out.println("库存服务端口"+port+"被调用了~~~~~~~~");
        return stockService.updateStockByProductId(productId,count);
    }

    //不同参数传递测试
    //1.普通参数
    @GetMapping("/test1")
    public String test1(
            @RequestParam Long productId ,
            @RequestParam Long count
    ){
        System.out.println("普通参数:"+productId+","+count);
        return "success";
    }
    //2.实体类对象
    @PostMapping("/test2")
    public String test2(
            @RequestBody StockEntity stock
            ){
        System.out.println(stock);
        return "success";
    }
    //3.集合类型参数
    @PostMapping("/test3")
    public String test3(
            @RequestBody Map map
    ){
        System.out.println(map);
        return "success";
    }
}
