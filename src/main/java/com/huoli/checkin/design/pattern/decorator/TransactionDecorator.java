package com.huoli.checkin.design.pattern.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：事务行为包装器(类似静态代理)<br>
 * 版权：Copyright (c) 2011-2018<br>
 * 公司：活力天汇<br>
 * 作者：廖浩<br>
 * 版本：1.0<br>
 * 创建日期：2018年8月7日<br>
 */
public class TransactionDecorator implements Command {
    private static Logger logger = LoggerFactory.getLogger(TransactionDecorator.class);

    private Command command;

    public TransactionDecorator(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        logger.debug("事务开始....");
        command.execute();
        logger.debug("事务结束....");
    }

}
