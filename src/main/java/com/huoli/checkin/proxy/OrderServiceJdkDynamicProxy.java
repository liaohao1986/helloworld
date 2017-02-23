/**
 * 
 */
package com.huoli.checkin.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月23日<br>
 */
public class OrderServiceJdkDynamicProxy implements AopProxy, InvocationHandler {

    /** 
     * 委托类对象 
     */
    private Object target;

    /** 
     * 绑定委托类的方法，同时会返回一个代理类对象。这个代理类会兼具权限检查的功能。 
     * @param target 
     * @return 
     */
    public Object getProxy(Object target) {
        this.target = target;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
        // 将动态生成的代理类对象返回给用户即可  
        return proxy;
    }

    /** 
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     * @see java.lang.reflect.InvocationHandler#invoke(java.lang.Object, java.lang.reflect.Method, java.lang.Object[])
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("用户利用JdkDynamicProxy输入参数打印....");
        Object object = method.invoke(target, args);
        System.out.println("用户利用JdkDynamicProxy输出参数打印....");
        // 权限校验完成后，调用委托类中的方法即可  
        return object;
    }
}
