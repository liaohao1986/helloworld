/**
 * 
 */
package com.huoli.checkin.proxy;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月23日<br>
 */
public class OrderServiceCGLibDynamicProxy implements AopProxy, MethodInterceptor {

    /** 
     * 委托类对象 
     */
    private Object target;

    /** 
     * 创建并返回委托类对象的代理类对象 
     */
    public Object getProxy(Object target) {

        this.target = target;
        Enhancer enhancer = new Enhancer();
        // 设置最后生成的代理类的父类  
        enhancer.setSuperclass(target.getClass());
        // 设置切面回调  
        enhancer.setCallback(this);

        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("用户利用CGLibDynamicProxy输入参数....");
        // 权限校验完成后，调用委托类中的方法即可  
        Object object = method.invoke(target, args);
        System.out.println("用户利用CGLibDynamicProxy输出参数....");
        return object;
    }
}
