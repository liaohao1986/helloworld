/**
 * 
 */
package com.huoli.checkin.design.pattern.proxy2;

import java.lang.reflect.Proxy;

/**
 * @author liaohao
 *
 */
public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Hello helloProxy = new HelloProxy(new HelloImpl());
//        helloProxy.sayHello("Jack");
//        
        Hello hello = new HelloImpl();
//
        DynamicProxy dynamicProxy = new DynamicProxy(hello);

        Hello helloProxy = dynamicProxy.getProxy();

        helloProxy.sayHello("Jack");
//        CGLibProxy cgLibProxy = new CGLibProxy();
        helloProxy = CGLibProxy.getInstance().getProxy(HelloImpl.class);

        helloProxy.sayHello("liaohao");
    }

}
