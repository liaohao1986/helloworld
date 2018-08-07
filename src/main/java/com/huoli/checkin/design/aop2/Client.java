package com.huoli.checkin.design.aop2;

import java.util.ArrayList;
import java.util.List;

import com.huoli.checkin.design.aop.GreetingImpl;

public class Client {

    public static void main(String[] args) {
        List<Proxy> proxyList = new ArrayList<Proxy>();
        proxyList.add(new BeforeProxy());
        proxyList.add(new AfterProxy());

        ProxyManager proxyManager = new ProxyManager(GreetingImpl.class, proxyList);
        GreetingImpl greetingProxy = proxyManager.createProxy();

        greetingProxy.sayHello("Jack");
    }
}