/**
 * 
 */
package com.huoli.checkin.design.pattern.chain.commons;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.chain.Context;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月1日<br>
 */
public class ChainBase implements Chain {
    private List<Command> commandList = new ArrayList<Command>();

    public ChainBase() {

    }

    public ChainBase(Command command) {
        addCommand(command);
    }

    public ChainBase(Command[] commands) {
        if (commands == null || commands.length == 0) {
            throw new IllegalArgumentException();
        }
        commandList.addAll(Arrays.asList(commands));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ChainBase(Collection commands) {
        if (commands == null || commands.size() == 0) {
            throw new IllegalArgumentException();
        }
        commandList.addAll(commands);
    }

    @Override
    public void addCommand(Command command) {
        commandList.add(command);
    }

    /** 
     * @param context
     * @return
     * @throws Exception
     * @see org.apache.commons.chain.Command#execute(org.apache.commons.chain.Context)
     */
    @Override
    public boolean execute(Context context) throws Exception {
        for (Command command : commandList) {
            try {
                if (!command.execute(context)) {
                    break;
                }
            } catch (Exception e) {
                break;
            }
        }
        return false;
    }

}
