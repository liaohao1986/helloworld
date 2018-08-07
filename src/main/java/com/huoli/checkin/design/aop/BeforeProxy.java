package com.huoli.checkin.design.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BeforeProxy implements MethodInterceptor {

    @SuppressWarnings("rawtypes")
    public Object getProxy(Class cls) {
        return Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        return proxy.invokeSuper(target, args);
    }

    private void before() {
        System.out.println("Before");
    }
}
