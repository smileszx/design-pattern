package com.victor.pattern.singleton.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * 负载均衡器客户端
 * @Author victor su
 * @Date 2019/10/7 19:32
 **/
public class LoadBalancerClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadBalancerClient.class);

    public static void main(String[] args) {
        LoadBalancer balancerA = LoadBalancer.getLoadBalancer();
        LoadBalancer balancerB = LoadBalancer.getLoadBalancer();
        LoadBalancer balancerC = LoadBalancer.getLoadBalancer();
        LoadBalancer balancerD = LoadBalancer.getLoadBalancer();

        if (balancerA == balancerB && balancerB == balancerC && balancerC == balancerD) {
            LOGGER.info("负载均衡器为单例模式, A:{}; B:{}, C:{}, D:{}", balancerA, balancerB, balancerC, balancerD);
        }

        balancerA.addServer("S1");
        balancerB.addServer("S2");
        balancerC.addServer("S3");
        balancerD.addServer("S4");

        for(int i=0; i<10; i++) {
            LOGGER.info("随机获取服务器: " + balancerA.getServerRandom());
        }

    }
}
