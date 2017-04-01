/**
 * 
 */
package com.huoli.checkin.design.pattern.templete.bank;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月31日<br>
 */
public class SavingAccount extends Account {
    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    /** 
     * 
     * @see com.huoli.checkin.design.pattern.templete.bank.Account#calculateInterest()
     */
    @Override
    public void calculateInterest() {
        logger.debug("按定期利率计算利息！");
    }

}
