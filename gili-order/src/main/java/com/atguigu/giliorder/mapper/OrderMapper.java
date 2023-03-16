package com.atguigu.giliorder.mapper;

import com.atguigu.giliorder.pojo.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ClassName: OrderMapper
 * Package: com.atguigu.giliorder.mapper
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 10:40
 * @Version 1.0
 */
public interface OrderMapper extends JpaRepository<Order,Long> {
}
