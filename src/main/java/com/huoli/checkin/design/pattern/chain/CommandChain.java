/**
 * 
 */
package com.huoli.checkin.design.pattern.chain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.Command;
import org.apache.commons.chain.Context;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月31日<br>
 */
public class CommandChain {
    //定义一个ArrayList来存储命令队列  
    private List<Command> commands = new ArrayList<Command>();

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void removeCommand(Command command) {
        commands.remove(command);
    }

    //循环调用每一个命令对象的execute()方法  
    public void execute(Context context) throws Exception {
        for (Command command : commands) {
            command.execute(context);
        }
    }
}
