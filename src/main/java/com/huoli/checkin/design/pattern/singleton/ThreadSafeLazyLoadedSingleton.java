/**
 * 
 */
package com.huoli.checkin.design.pattern.singleton;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月17日<br>
 */
public class ThreadSafeLazyLoadedSingleton {

    private static ThreadSafeLazyLoadedSingleton singleton = null;

    private ThreadSafeLazyLoadedSingleton() {

    }

    public synchronized static ThreadSafeLazyLoadedSingleton getInstance() {
        if (singleton == null) {
            singleton = new ThreadSafeLazyLoadedSingleton();
        }
        return singleton;
    }

}
