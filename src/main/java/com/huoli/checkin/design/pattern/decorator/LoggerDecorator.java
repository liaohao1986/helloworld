package com.huoli.checkin.design.pattern.decorator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 描述：<br>
 * 版权：Copyright (c) 2011-2018<br>
 * 公司：活力天汇<br>
 * 作者：廖浩<br>
 * 版本：1.0<br>
 * 创建日期：2018年8月7日<br>
 */
public class LoggerDecorator implements Command {
    private static Logger logger = LoggerFactory.getLogger(LoggerDecorator.class);

    private Command command;

    public LoggerDecorator(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {
        logger.debug("打印日志开始....");
        command.execute();
        logger.debug("打印日志结束....");
    }

}
