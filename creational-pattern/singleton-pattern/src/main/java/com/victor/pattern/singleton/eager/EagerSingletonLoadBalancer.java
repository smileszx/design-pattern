package com.victor.pattern.singleton.eager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * 饿汉式单例负载均衡器，不能实现延迟加载
 * @Author victor su
 * @Date 2019/10/7 19:22
 **/
public class EagerSingletonLoadBalancer {
    /**
     * 在定义静态变量的时候实例化单例类，因此在类加载的时候就已经创建了单例对象
     */
    private static EagerSingletonLoadBalancer instance = new EagerSingletonLoadBalancer();

    private List serverList = null;

    private EagerSingletonLoadBalancer() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serverList = new ArrayList();
    }

    /**
     * 当类被加载时，静态变量instance会被初始化，此时类的私有构造函数会被调用，
     * 单例类的唯一实例将被创建。如果使用饿汉式单例来实现负载均衡器LoadBalancer类的设计，
     * 则不会出现创建多个单例对象的情况，可确保单例对象的唯一性。
     * @return
     */
    public static EagerSingletonLoadBalancer getLoadBalancer () {
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
