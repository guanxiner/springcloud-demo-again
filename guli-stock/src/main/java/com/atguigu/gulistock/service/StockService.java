package com.atguigu.gulistock.service;

import com.atguigu.gulistock.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassName: StockService
 * Package: com.atguigu.gulistock.service
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 10:19
 * @Version 1.0
 */
@Service
public class StockService {
    @Autowired
    private StockMapper stockMapper;
    public int updataStockByProductIdAndCount(Long productId, Long count) {
     return   stockMapper.updataStockByProductIdAndCount(productId,count);
    }
}
