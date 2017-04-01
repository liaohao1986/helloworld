/**
 * 
 */
package com.huoli.checkin.design.pattern.chain.commons;

import org.apache.commons.chain.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月1日<br>
 */
public class QueryCommand implements Command {
    private static Logger logger = LoggerFactory.getLogger(QueryCommand.class);

    /** 
     * @param context
     * @return
     * @throws Exception
     * @see com.huoli.checkin.design.pattern.chain.commons.Command#execute(org.apache.commons.chain.Context)
     */
    @Override
    public boolean execute(Context context) throws Exception {
        logger.debug("{}", "execute queryCommand");
        return true;
    }

}
