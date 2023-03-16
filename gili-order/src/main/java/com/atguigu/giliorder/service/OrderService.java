package com.atguigu.giliorder.service;

import com.atguigu.giliorder.mapper.OrderMapper;
import com.atguigu.giliorder.pojo.Order;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

/**
 * ClassName: OrderService
 * Package: com.atguigu.giliorder.service
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 10:41
 * @Version 1.0
 */
@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private RestTemplate restTemplate;
    public Boolean createOrder(Long userId, Long count, Long productId) {
        boolean flag = true;
        //封装order对象
        Order order = new Order();
        order.setProductId(productId);
        order.setUserId(userId);
        order.setOrderSn(UUID.randomUUID().toString().replace("-",""));
        order.setCount(count);
        order.setMoney(new BigDecimal(100*count));
        order.setCreateTime(new Date());
        //订单库生成订单
       if (orderMapper.save(order)!=null){
         flag=true;
       }
        //库存库减库存(方法1需要借助HttpClient,pom添加对应依赖)
//        try {
//            CloseableHttpClient httpClient = HttpClients.createDefault();
//            HttpGet httpGet = new HttpGet("http://localhost:8080/stock/save/"+ productId +"/"+ count );//"http://"不能省略
//            CloseableHttpResponse response = httpClient.execute(httpGet);
//            int statusCode = response.getStatusLine().getStatusCode();
//            System.out.println(statusCode);
//            HttpEntity entity = response.getEntity();
//            String s = EntityUtils.toString(entity);
//            flag = Boolean.parseBoolean(s);
//        } catch (IOException e) {
//            e.printStackTrace();
//            flag=false;
//        }
        //库存库减库存(方法2需要借助Ribbon提供的远程调用工具,pom添加对应依赖,并添加ReatTeplate配置类)
//          flag = restTemplate.getForObject("http://GULI-STOCK/stock/save/" + productId + "/" + count, Boolean.class);
            flag = restTemplate.getForObject("http://GULI-STOCK/stock/save/{1}/{2}", Boolean.class, productId, count);

        return flag;
    }
}
