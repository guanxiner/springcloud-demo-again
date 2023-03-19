package com.atguigu.guli.order.service;

import com.atguigu.guli.order.entity.OrderEntity;
import com.atguigu.guli.order.mapper.OrderMapper;
import com.atguigu.guli.order.openfeign.GiliStockNacosClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.event.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Service
@Slf4j
public class OrderService {
    @Autowired
    OrderMapper orderMapper;
    @Resource
    private GiliStockNacosClient giliStockNacosClient;
    Boolean flag;
    //创建订单
    public boolean saveOrder(Long userId,Long productId,Long count){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCount(count);
        orderEntity.setOrderSn(UUID.randomUUID().toString().replace("-",""));
        orderEntity.setCreateTime(new Date());
        orderEntity.setMoney(new BigDecimal(1000));
        orderEntity.setProductId(productId);
        orderEntity.setUserId(userId);
        orderEntity = orderMapper.save(orderEntity);
        System.out.println(orderEntity);
        flag=orderEntity!=null;
        //TODO: 更新库存
//        try {
//            //初始化客户端
//            HttpClient httpclient = HttpClients.createDefault();
//            //设置get请求地址
//            HttpGet httpGet = new HttpGet("http://localhost:8082/stock/"+productId+"/"+count);
//            //执行请求得到结果
//            HttpResponse response = httpclient.execute(httpGet);
//            boolean b = Boolean.parseBoolean(EntityUtils.toString(response.getEntity()));
//            System.out.println("库存更新结果 ："+b);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        flag = giliStockNacosClient.updateNacosStock(productId, count);
        System.out.println(flag);
        return flag;
    }
//    public boolean saveOrderFallBack(String userId,String productId,Integer count){
//        Level.ERROR
//
//    }

}
