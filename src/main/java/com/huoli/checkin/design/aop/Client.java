package com.huoli.checkin.design.aop;

public class Client {

    public static void main(String[] args) {
        Object greetingImplBeforeProxy = new BeforeProxy().getProxy(GreetingImpl.class);
        Object greetingImplAfterBeforeProxy = new AfterProxy().getProxy(greetingImplBeforeProxy.getClass());

        GreetingImpl greetingImpl = (GreetingImpl) greetingImplBeforeProxy;

        greetingImpl.sayHello("Jack");
    }
}