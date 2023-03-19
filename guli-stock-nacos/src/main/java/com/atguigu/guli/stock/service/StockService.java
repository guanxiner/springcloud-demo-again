package com.atguigu.guli.stock.service;

import com.atguigu.guli.stock.entity.StockEntity;
import com.atguigu.guli.stock.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class StockService  {
    @Autowired
    StockMapper stockMapper;
    //根据商品id查询库存的方法
    public StockEntity queryStockEntityByProductId(Long productId){
        return stockMapper.findByProductId(productId);
    }
    //更新商品id更新库存
    public Boolean updateStockByProductId(Long productId,Long count){
        return stockMapper.updateCountByProductId(productId,count)==1;
    }
}
