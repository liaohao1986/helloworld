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
public interface CallBack {
    /** 
     * 这个是小李知道答案时要调用的函数告诉小王，也就是回调函数 
     * @param result 是答案 
     */
    public void solve(String result);
}