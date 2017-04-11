/**
 * 
 */
package com.huoli.checkin.design.pattern.nullobject;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月7日<br>
 */
public class RealObject implements AbstractCustomer {

    /** 
     * @return
     * @see com.huoli.checkin.design.pattern.nullobject.AbstractCustomer#query()
     */
    @Override
    public String query() {
        return "can not find this student";
    }

}
