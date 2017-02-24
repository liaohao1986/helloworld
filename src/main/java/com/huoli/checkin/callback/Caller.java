/**
 * 
 */
package com.huoli.checkin.callback;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月24日<br>
 */
public class Caller {
    private CallBack callBack;

    public Caller() {

    }

    public void setCallFunc(CallBack callBack) {
        this.callBack = callBack;
    }

    public void call() {
        callBack.solve("123");
    }
}
