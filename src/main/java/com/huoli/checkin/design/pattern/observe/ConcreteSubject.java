/**
 * 
 */
package com.huoli.checkin.design.pattern.observe;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月27日<br>
 */
public class ConcreteSubject implements Subject {

    List<Observer> ObserverList = new ArrayList<Observer>();

    public void attach(Observer observer) {
        ObserverList.add(observer);
    }

    public void detach(Observer observer) {
        ObserverList.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : ObserverList) {
            observer.update();
        }
    }

}
