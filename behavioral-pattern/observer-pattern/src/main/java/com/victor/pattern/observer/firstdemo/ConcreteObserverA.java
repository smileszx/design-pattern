package com.victor.pattern.observer.firstdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * 具体观察者A
 * @Author victor su
 * @Date 2019/10/7 21:53
 **/
public class ConcreteObserverA implements Observer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConcreteObserverA.class);
    @Override
    public void update() {
        System.out.println("更新...");
    }

    @Override
    public void update(String state) {
        LOGGER.info("我是观察者A: 更新后状态=> {}", state);
    }
}
