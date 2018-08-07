package com.huoli.checkin.design.pattern.proxy2;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodProxy;

public class CGLibProxy implements  net.sf.cglib.proxy.MethodInterceptor {
    
    private static CGLibProxy cgLibProxy = new CGLibProxy();
    
    private CGLibProxy() {}
    
    public static CGLibProxy getInstance() {
        return cgLibProxy;
    }

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();
        return result;
    }

    private void before() {
        System.out.println("Before");
    }

    private void after() {
        System.out.println("After");
    }

}
