package com.victor.pattern.singleton.lazy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * 懒汉式单例负载均衡器，延迟加载
 * @Author victor su
 * @Date 2019/10/7 19:59
 **/
public class LazySingletonLoadBalancer {
    /**
     * volatile 修饰， 内存可见性 和 防止指令重排序
     */
    private static volatile LazySingletonLoadBalancer instance = null;

    private List serverList = null;

    private LazySingletonLoadBalancer() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serverList = new ArrayList();
    }

    /**
     * 双重检查锁定(Double-Check Locking)
     * @return
     */
    public static LazySingletonLoadBalancer getLoadBalancer () {

        // 第一重判断
        if (instance == null) {
            //锁定代码块，最小粒度加锁
            //加类锁，一定程度影响性能
            synchronized (LazySingletonLoadBalancer.class) {
                // 第二重判断
                if (instance == null) {
                    /**
                     * 非原子性，指令重排序会导致并发场景下创建多个实例，需要volatile修饰instance变量
                     */
                    instance = new LazySingletonLoadBalancer();
                }
            }
        }

        return instance;
    }

    /**
     *
     * 新增服务器
     * @param server
     */
    public void addServer (String server) {
        serverList.add(server);
    }

    /**
     * 移除服务器
     * @param server
     */
    public void removeServer (String server) {
        serverList.remove(server);
    }

    /**
     * 随机获取服务器
     * @return
     */
    public String getServerRandom () {

        Random random = new Random();
        int i = random.nextInt(serverList.size());

        return (String) serverList.get(i);
    }
}
