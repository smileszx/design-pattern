package com.victor.pattern.proxy.cglib;

import com.victor.pattern.proxy.service.PayService;
import com.victor.pattern.proxy.service.impl.AliPayServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @Description
 * CGLIB(Code Generation Library) 动态代理
 * 目标对象不需要实现接口
 * @Author victor su
 * @Date 2019/10/5 14:42
 **/
public class PayServiceCglibProxyClient {

    public static void main(String[] args) {
        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(AliPayServiceImpl.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new MyMethodInterceptor());
        // 创建代理对象
        AliPayServiceImpl proxy= (AliPayServiceImpl) enhancer.create();
        // 通过代理对象调用目标方法
        proxy.pay();
    }
}
