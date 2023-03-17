package com.atguigu.gulistock.controller;

import com.atguigu.gulistock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * ClassName: StockController
 * Package: com.atguigu.gulistock.controller
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 10:12
 * @Version 1.0
 */
@RestController
@RequestMapping("/stock")
public class StockController {
   @Value("${server.port}")
   private Integer port;
    @Autowired
    private StockService stockService;
    //前端输入productId和数量去仓库扣减
    @GetMapping("/save/{productId}/{count}")
    public Boolean save(
            @PathVariable("productId") Long productId,
            @PathVariable("count") Long count,
            @CookieValue(value = "token",required = false)String token
    ){
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        System.out.println("选择了----->"+port);
        System.out.println(token);
        return stockService.updataStockByProductIdAndCount(productId, count)==1;
    }
}
