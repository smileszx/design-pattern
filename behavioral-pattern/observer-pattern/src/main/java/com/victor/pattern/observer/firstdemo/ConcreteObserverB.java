package com.victor.pattern.observer.firstdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * 具体观察者B
 * @Author victor su
 * @Date 2019/10/7 21:53
 **/
public class ConcreteObserverB implements Observer {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConcreteObserverB.class);
    @Override
    public void update() {
        System.out.println("更新...");
    }

    @Override
    public void update(String state) {
        LOGGER.info("我是观察者B: 更新后状态=> {}", state);
    }
}
