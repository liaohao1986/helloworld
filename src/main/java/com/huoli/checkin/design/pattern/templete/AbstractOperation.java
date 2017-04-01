/**
 * 
 */
package com.huoli.checkin.design.pattern.templete;

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
public abstract class AbstractOperation {
    private static Logger logger = LoggerFactory.getLogger(AbstractOperation.class);

    //模板方法  
    public void execute() {
        beforeOperation();
        doOperation1();
        doOperation2();
        afterOperation();
    }

    //基本方法—具体方法  
    public void beforeOperation() {
        //实现代码  
        logger.debug("execute beforeOperation");
    }

    //基本方法—抽象方法  
    public abstract void doOperation1();

    //基本方法—钩子方法  
    public abstract void doOperation2();

    //基本方法—具体方法  
    public void afterOperation() {
        //实现代码  
        logger.debug("execute afterOperation");
    }
}
