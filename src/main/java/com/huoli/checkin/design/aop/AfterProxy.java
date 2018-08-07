package com.huoli.checkin.design.aop;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class AfterProxy implements MethodInterceptor {

    @SuppressWarnings("rawtypes")
    public Object getProxy(Class cls) {
        return Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object target, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        Object result = proxy.invokeSuper(target, args);
        after();
        return result;
    }

    private void after() {
        System.out.println("After");
    }
}