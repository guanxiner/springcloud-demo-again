package com.atguigu.gulistock.mapper;

import com.atguigu.gulistock.pojo.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * ClassName: StockMapper
 * Package: com.atguigu.gulistock.mapper
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 10:22
 * @Version 1.0
 */
public interface StockMapper extends JpaRepository<Stock,Long> {
    @Transactional
    @Modifying
    @Query("update Stock s set s.count=s.count-?2 where s.productId=?1")
    int updataStockByProductIdAndCount(Long productId, Long count);
}
