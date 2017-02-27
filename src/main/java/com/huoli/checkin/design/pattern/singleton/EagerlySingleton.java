/**
 * 
 */
package com.huoli.checkin.design.pattern.singleton;

/**
 * 饿汉式单例模式 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月17日<br>
 */
public class EagerlySingleton {
    private static EagerlySingleton instance = new EagerlySingleton();

    private EagerlySingleton() {

    }

    public static EagerlySingleton getInstance() {
        return instance;
    }

}
