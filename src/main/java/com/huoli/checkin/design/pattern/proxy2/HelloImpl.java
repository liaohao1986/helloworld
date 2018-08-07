package com.huoli.checkin.design.pattern.proxy2;

public class HelloImpl implements Hello {

    @Override
    public void sayHello(String name) {
       System.out.println("Hello,"+name);
    }
}
