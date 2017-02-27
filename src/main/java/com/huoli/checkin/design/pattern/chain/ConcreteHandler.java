/**
 * 
 */
package com.huoli.checkin.design.pattern.chain;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月17日<br>
 */
public class ConcreteHandler extends Handler {

    /** 
     * 处理方法，调用此方法处理请求 
     */
    @Override
    public void handleRequest() {
        /** 
         * 判断是否有后继的责任对象 
         * 如果有，就转发请求给后继的责任对象 
         * 如果没有，则处理请求 
         */
        if (getSuccessor() != null) {
            System.out.println("放过请求");
            getSuccessor().handleRequest();
        } else {
            System.out.println("处理请求");
        }
    }

}
