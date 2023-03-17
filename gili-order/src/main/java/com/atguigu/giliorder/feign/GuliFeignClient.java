package com.atguigu.giliorder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ClassName: FeignClient
 * Package: com.atguigu.giliorder.feign
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 16:53
 * @Version 1.0
 */
@FeignClient(value = "GULI-STOCK")
public interface GuliFeignClient {
    @GetMapping("/save/{productId}/{count}")
    public Boolean updeStock(
            @PathVariable("productId") Long productId,
            @PathVariable("count") Long count
    );

}
