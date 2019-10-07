package com.victor.pattern.singleton.init;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * 内部静态类
 * @Author victor su
 * @Date 2019/10/7 20:51
 **/
public class InitDemandHolderLoadBalancer {

    private List serverList = null;

    private InitDemandHolderLoadBalancer() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serverList = new ArrayList();
    }

    /**
     * 内部静态类
     * 内部类中定义了一个static类型的变量instance，
     * 此时会首先初始化这个成员变量，由Java虚拟机来保证其线程安全性，
     * 确保该成员变量只能初始化一次。
     */
    static class InitDemandHolder {
        private static InitDemandHolderLoadBalancer instance = new InitDemandHolderLoadBalancer();

    }

    /**
     * getInstance()方法没有任何线程锁定，因此其性能不会造成任何影响。
     * 实现延迟加载，又可以保证线程安全，不影响系统性能。
     * @return
     */
    public static InitDemandHolderLoadBalancer getLoadBalancer () {
        return InitDemandHolder.instance;
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
