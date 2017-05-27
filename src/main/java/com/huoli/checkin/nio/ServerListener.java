/**
 * 
 */
package com.huoli.checkin.nio;

import java.io.Serializable;
import java.util.Map;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年5月26日<br>
 */
public interface ServerListener extends Serializable {
    /**
     * 可读事件回调
     * @param request
     */
    void onRead(Object ctx);

    /**
     * 可写事件回调
     * @param request
     * @param response
     */
    void onWrite(Object ctx);

    /**
     * 连接关闭回调
     * @param request
     */
    void onClosed(Object ctx);
}
