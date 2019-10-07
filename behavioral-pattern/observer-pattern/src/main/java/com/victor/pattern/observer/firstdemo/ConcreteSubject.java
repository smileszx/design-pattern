package com.victor.pattern.observer.firstdemo;

/**
 * @Description
 * 具体目标是目标类的子类
 * @Author victor su
 * @Date 2019/10/7 21:51
 **/
public class ConcreteSubject extends Subject{

    private String state;

    /**
     * 状态更改
     * @param state
     */
    public void setState(String state) {
        this.state = state;
        notifyMethod();
    }

    @Override
    public void notifyMethod() {
        //遍历观察者集合，调用每一个观察者的响应方法
        for(Object obs:observers) {
            ((Observer) obs).update(state);
        }
    }
}
