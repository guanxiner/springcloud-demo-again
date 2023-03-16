package com.atguigu.giliorder.controller;

import com.atguigu.giliorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName: OrderController
 * Package: com.atguigu.giliorder.controller
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 10:41
 * @Version 1.0
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    //根据userId,count,productId创建订单
    @GetMapping("/create/{userId}/{count}/{productId}")
    public Boolean createOrder(
            @PathVariable("userId") Long userId,
            @PathVariable("count") Long count,
            @PathVariable("productId") Long productId
    ){
        Boolean b = orderService.createOrder(userId, count, productId);
        return b;
    }
}
