package com.victor.pattern.singleton.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description
 * 模拟并发环境
 * @Author victor su
 * @Date 2019/10/7 20:59
 **/
public class LoadBalancerConcurrentClient {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoadBalancerConcurrentClient.class);
    private static ExecutorService pool = Executors.newFixedThreadPool(10);
    private static Set<String> set = new HashSet<>();

    private static CountDownLatch latch = new CountDownLatch(20);

    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<20; i++) {
            pool.submit(new InitLoadBalancer());
        }
        latch.await();
        pool.shutdown();
        LOGGER.info("负责均衡器: {}", set);
    }


    /**
     * 初始化单例负载均衡器
     */
    static class InitLoadBalancer implements Runnable {
        public InitLoadBalancer () {
            LOGGER.info("=== 负载均衡初始化任务 ===");
        }

        @Override
        public void run() {
            LoadBalancer loadBalancer = LoadBalancer.getLoadBalancer();
            set.add(loadBalancer.toString().split("@")[1]);
            LOGGER.info(Thread.currentThread().getName() + ", 负载均衡器 => {}", loadBalancer);
            latch.countDown();
        }
    }
}
