package com.atguigu.giliorder.rule;

import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.Server;
import org.springframework.boot.SpringBootConfiguration;

import java.util.List;
import java.util.Random;

/**
 * ClassName: EurekaRule
 * Package: com.atguigu.giliorder.rule
 * Description:
 *
 * @Author 王宝民
 * @Create 2023/3/16 14:06
 * @Version 1.0
 */
public class EurekaRule extends RandomRule {

    @Override
    public Server choose(ILoadBalancer lb, Object key) {
        List<Server> allServers = lb.getAllServers();//所有服务
        List<Server> reachableServers = lb.getReachableServers();//可用的在线的服务
        int size = reachableServers.size();
        int i = new Random().nextInt(size);
        return reachableServers.get(i);
    }
}
