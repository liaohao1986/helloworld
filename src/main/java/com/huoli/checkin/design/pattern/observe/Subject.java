/**
 * 
 */
package com.huoli.checkin.design.pattern.observe;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月27日<br>
 */
public interface Subject {

    void attach(Observer observe);

    void detach(Observer observe);

    void notifyObservers();

}
