/**
 * 
 */
package com.huoli.checkin.proxy;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月23日<br>
 */
public class DefaultDynamicProxyFactory {

    AopProxy createAopProxy(Object target) {
        //        Class<?>[] targetInterfaces = target.getClass().getInterfaces();

        //如果是接口编程，用jdk动态代理
        if (target.getClass().getInterfaces().length >= 1) {
            return new OrderServiceJdkDynamicProxy();
        }
        return new OrderServiceCGLibDynamicProxy();
    }
}
