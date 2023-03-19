package com.atguigu.guli.stock.mapper;

import com.atguigu.guli.stock.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import javax.transaction.Transactional;

public interface StockMapper extends JpaRepository<StockEntity , Long> {
    StockEntity findByProductId(Long productId);
    //@Query：自定义sql实现查询，@Modifying：指定sql为更新,不添加此注解表示查询
    @Transactional
    @Modifying
    @Query("update StockEntity s set s.count = s.count - ?2 where s.productId = ?1")
    int updateCountByProductId(Long productId, Long count);
}
