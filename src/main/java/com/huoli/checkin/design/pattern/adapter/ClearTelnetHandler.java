/**
 * 
 */
package com.huoli.checkin.design.pattern.adapter;

import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.RemotingException;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月1日<br>
 */
public class ClearTelnetHandler implements TelnetHandler {

    /** 
     * @param channel
     * @param message
     * @return
     * @throws RemotingException
     * @see com.huoli.checkin.design.pattern.adapter.TelnetHandler#telnet(com.alibaba.dubbo.remoting.Channel, java.lang.String)
     */
    @Override
    public String telnet(Channel channel, String message) throws RemotingException {
        return null;
    }

}
