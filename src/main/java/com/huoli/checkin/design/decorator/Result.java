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
public class Result {

    private Object object;
    private String sql;

    /**
     * @param object
     * @param sql
     */
    public Result(Object object, String sql) {
        super();
        this.object = object;
        this.sql = sql;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

}
