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
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        //组装责任链  
        Handler handler1 = new ConcreteHandler();
        Handler handler2 = new ConcreteHandler();
        handler1.setSuccessor(handler2);
        //提交请求  
        handler1.handleRequest();
    }

}
