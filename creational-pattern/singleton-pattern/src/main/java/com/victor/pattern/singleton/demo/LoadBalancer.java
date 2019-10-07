package com.victor.pattern.singleton.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Description
 * 单例负载均衡器
 * @Author victor su
 * @Date 2019/10/7 19:22
 **/
public class LoadBalancer {
    private static LoadBalancer instance = null;

    private List serverList = null;

    private LoadBalancer () {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        serverList = new ArrayList();
    }

    /**
     * 一言以蔽之: instance= new LoadBalancer()过程非原子性，非线程安全！
     *
     * instance对象为null值，因此系统将执行代码instance= new LoadBalancer()，在此过程中，
     * 由于要对LoadBalancer进行大量初始化工作，需要一段时间来创建LoadBalancer对象。
     * 而在此时，如果再一次调用getLoadBalancer()方法（通常发生在多线程环境中） ，
     * 由于instance尚未创建成功，仍为null值，判断条件(instance== null)为真值，
     * 因此代码instance= new LoadBalancer()将再次执行，导致最终创建了多个instance对象，
     * 这违背了单例模式的初衷，也导致系统运行发生错误。
     * @return
     */
    public static LoadBalancer getLoadBalancer () {
        if(instance == null) {
            instance = new LoadBalancer();
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
