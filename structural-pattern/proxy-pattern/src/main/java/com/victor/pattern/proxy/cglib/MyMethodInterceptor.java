package com.victor.pattern.proxy.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description
 * 自定义拦截器
 * @Author victor su
 * @Date 2019/10/5 14:51
 **/
public class MyMethodInterceptor implements MethodInterceptor {


    /**
     * 方法拦截器
     * @param obj 表示增强的对象，即实现这个接口类的一个对象
     * @param method 表示要被拦截的方法
     * @param args 表示要被拦截方法的参数
     * @param methodProxy 表示要触发父类的方法对象
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy)
            throws Throwable {
        System.out.println("======插入前置通知======");
        Object object = methodProxy.invokeSuper(obj, args);
        System.out.println("======插入后者通知======");
        return object;
    }
}
