/**
 * 
 */
package com.huoli.checkin.design.spring.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月5日<br>
 */
public class App {

    /**
     *
     * @param args
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
//                ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
//                Human human = (Human) ctx.getBean("human");
        //Car car = (Car) ctx.getBean("car");
        //human.setCar(car);
        //        human.myCarRun();

        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("app-bean.xml");
//        ctx.start();
        Human human = (Human) ctx.getBean("human");
        //Car car = (Car) ctx.getBean("car");
        //human.setCar(car);
        human.myCarRun();
    }

}
