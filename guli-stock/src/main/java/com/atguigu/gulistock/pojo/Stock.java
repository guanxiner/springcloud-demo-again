package com.atguigu.gulistock.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * ClassName: Stock
 * Package: com.atguigu.gulistock.pojo
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 10:07
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "t_stock")
public class Stock {
    @Id
    private Long id ;
    @Column(name = "product_id")
    private Long productId;

    private String title;

    private Long count;
}
