/**
 * 
 */
package com.huoli.checkin.nio;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年5月26日<br>
 */
public class EventAdapter implements ServerListener {

    /** */
    private static final long serialVersionUID = 7829036177166598885L;

    /** 
     * @param ctx
     * @see com.huoli.checkin.nio.ServerListener#onRead(java.lang.Object)
     */
    @Override
    public void onRead(Object ctx) {
    }

    /** 
     * @param ctx
     * @see com.huoli.checkin.nio.ServerListener#onWrite(java.lang.Object)
     */
    @Override
    public void onWrite(Object ctx) {
    }

    /** 
     * @param ctx
     * @see com.huoli.checkin.nio.ServerListener#onClosed(java.lang.Object)
     */
    @Override
    public void onClosed(Object ctx) {
    }

}
