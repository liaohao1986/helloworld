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
public abstract class Account {
    private static final Logger logger = LoggerFactory.getLogger(Account.class);

    public boolean validate(String account, String password) {
        //模拟登录  
        if (account.equals("张无忌") && password.equals("123456")) {
            return true;
        }
        return false;

    }

    //基本方法——具体方法  
    public void display() {
        logger.debug("显示利息！");
    }

    //模板方法  
    public void handle(String account, String password) {
        if (!validate(account, password)) {
            logger.debug("账户或密码错误！");
            return;
        }
        calculateInterest();
        display();
    }

    //基本方法——抽象方法  
    public abstract void calculateInterest();
}
