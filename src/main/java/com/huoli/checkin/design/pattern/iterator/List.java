/**
 * 
 */
package com.huoli.checkin.design.pattern.iterator;

import java.util.Iterator;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月21日<br>
 */
public interface List<T> extends Iterator<T>{
    
    void add(T t);
    void remove(Object o);
    int size();
    
    

}
