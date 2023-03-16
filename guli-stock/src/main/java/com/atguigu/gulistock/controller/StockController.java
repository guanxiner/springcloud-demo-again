package com.atguigu.gulistock.controller;

import com.atguigu.gulistock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
            @PathVariable("count") Long count
    ){
        System.out.println("选择了----->"+port);
        int i = stockService.updataStockByProductIdAndCount(productId, count);
        return i==1;
    }
}
