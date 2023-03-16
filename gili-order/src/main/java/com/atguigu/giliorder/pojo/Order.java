package com.atguigu.giliorder.pojo;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * ClassName: Order
 * Package: com.atguigu.giliorder.pojo
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 10:40
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "t_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//数据库Id主键自增
    private Long id ;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "order_sn")
    private String orderSn;

    private Long count;

    private BigDecimal money;

    @Column(name = "create_time")
    private Date createTime;
}
