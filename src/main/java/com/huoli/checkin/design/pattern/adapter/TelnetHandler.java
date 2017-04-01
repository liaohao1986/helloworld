/**
 * 
 */
package com.huoli.checkin.design.pattern.adapter;

import com.alibaba.dubbo.remoting.Channel;
import com.alibaba.dubbo.remoting.RemotingException;

public interface TelnetHandler {

    /**
     * telnet.
     * 
     * @param channel
     * @param message
     */
    String telnet(Channel channel, String message) throws RemotingException;

}
