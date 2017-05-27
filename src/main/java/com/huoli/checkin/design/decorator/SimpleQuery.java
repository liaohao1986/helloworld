/**
 * 
 */
package com.huoli.checkin.design.decorator;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月24日<br>
 */
public class SimpleQuery implements Query {

    /** 
     * @param sql
     * @return
     * @see com.huoli.checkin.design.decorator.Query#query(java.lang.String)
     */
    @Override
    public Result query(String sql) {
        System.out.println("简单查询方式,sql=" + sql);
        return new Result(new Object(), sql);
    }

}
