/**
 * 
 */
package com.huoli.checkin.design.pattern.observe.jdk;

import java.util.Observable;
import java.util.Observer;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月27日<br>
 */
public class Watcher implements Observer {

    private String name;

    public Watcher(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        String str = (String) arg;
        System.out.println("观察者" + name + "收到参数请求变化,news=" + str);
    }

}
