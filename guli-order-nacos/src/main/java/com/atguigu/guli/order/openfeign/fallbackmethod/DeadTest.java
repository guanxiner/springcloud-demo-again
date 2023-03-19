package com.atguigu.guli.order.openfeign.fallbackmethod;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.stereotype.Component;

/**
 * ClassName: DeadTest
 * Package: com.atguigu.guli.order.openfeign.fallbackmethod
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/19 17:03
 * @Version 1.0
 */
@Component
public class DeadTest {
    public static String deadTest(Long pid, Long count, BlockException blockException){
        System.out.println("deadTest---购买商品的id为："+pid+" , 数量："+count+" , 异常： "+ blockException);
        return "dead_test";
    }
}
