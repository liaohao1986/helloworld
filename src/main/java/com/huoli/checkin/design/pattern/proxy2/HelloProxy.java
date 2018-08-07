package com.huoli.checkin.design.pattern.proxy2;

public class HelloProxy implements Hello {
    
    private Hello hello;
    
    public HelloProxy(Hello hello) {
        this.hello = hello;
    }

    @Override
    public void sayHello(String name) {
        before();
        hello.sayHello(name);
        after();
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }
}
