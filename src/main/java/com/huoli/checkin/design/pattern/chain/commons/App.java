/**
 * 
 */
package com.huoli.checkin.design.pattern.chain.commons;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.chain.Context;
import org.apache.commons.chain.impl.ContextBase;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月1日<br>
 */
public class App {

    /**
     *
     * @param args
     * @throws Exception 
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        List<Command> commandList = new ArrayList<Command>(10);
        commandList.add(new QueryCommand());
        commandList.add(new MergeCommand());
        commandList.add(new FilterCommand());
        commandList.add(new StatusCommand());
        Chain chain = new ChainBase(commandList);
        Context context = new ContextBase();
        context.put("phoneId", "412343");
        chain.execute(context);

    }
}
