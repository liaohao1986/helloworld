package com.huoli.checkin.design.pattern.rpc;

/** 
 * HelloServiceImpl 
 *  
 * @author william.liangf 
 */
public class HelloServiceImpl implements HelloService {

    public String hello(String name) {
        return "Hello " + name;
    }
}