package com.atguigu.guli.order.entity;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "t_order")
@Data
public class OrderEntity {
    @Id
    //id生成策略 ：数据库主键自增
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_id")
    private Long productId;
    private Long userId;
    private String orderSn;
    private Long count;
    private BigDecimal money;
    private Date createTime;
}
