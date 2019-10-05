package com.victor.pattern.proxy.jdk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Proxy;

/**
 * @Description
 * 支付方式代理类
 * @Author victor su
 * @Date 2019/10/5 10:10
 **/
public class PayServiceJDKProxy<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(PayServiceJDKProxy.class);

    public void before () {
        LOGGER.info("代理类===> 检查支付方式是否安全");
    }

    public void after () {
        LOGGER.info("代理类===> 成功完成支付");
    }

    /**
     * 创建代理类实例
     * @param serviceInterface 被代理的接口
     * @param proxyInstance 被代理的接口实现类
     * @return
     */
    public T createProxy(final Class<T> serviceInterface, final Class<? extends T> proxyInstance) {

        return (T) Proxy.newProxyInstance(serviceInterface.getClassLoader(), new Class[]{serviceInterface},
                (proxy, method, args) -> {
                    before();
                    Object object = method.invoke(proxyInstance.getConstructor().newInstance(),args);
                    after();
                    return object;
                }
       );
    }
}
