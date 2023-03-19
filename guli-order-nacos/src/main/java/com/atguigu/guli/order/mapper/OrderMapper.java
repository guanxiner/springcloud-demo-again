package com.atguigu.guli.order.mapper;

import com.atguigu.guli.order.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
public interface OrderMapper extends JpaRepository<OrderEntity ,Integer> {
}
