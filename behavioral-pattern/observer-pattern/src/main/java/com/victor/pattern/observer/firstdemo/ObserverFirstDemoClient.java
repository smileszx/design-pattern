package com.victor.pattern.observer.firstdemo;

/**
 * @Description
 *
 * @Author victor su
 * @Date 2019/10/7 21:58
 **/
public class ObserverFirstDemoClient {
    public static void main(String[] args) {

        ConcreteSubject subject = new ConcreteSubject();
        subject.attach(new ConcreteObserverA());
        subject.attach(new ConcreteObserverB());
        subject.attach(new ConcreteObserverC());
        subject.setState("邢晗铭");
        subject.setState("李荣浩");
    }
}
