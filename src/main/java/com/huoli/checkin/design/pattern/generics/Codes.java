/**
 * 
 */
package com.huoli.checkin.design.pattern.generics;

import java.io.IOException;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年6月2日<br>
 */
public interface Codes<T> {

    byte[] encode(T t) throws IOException;

    T decode(byte[] bytes) throws IOException;
}
