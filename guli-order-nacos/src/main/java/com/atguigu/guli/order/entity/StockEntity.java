package com.atguigu.guli.order.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
public class StockEntity {
    private Long id;
    private Long productId;
    private String title;
    private Long count;
}
