/**
 * 
 */
package com.huoli.checkin.design.spring.ioc;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月5日<br>
 */
public class BMWCar implements Car {

    private String myBrand = "BWM";

    /** 
     * @return
     * @see com.huoli.checkin.design.spring.ioc.Car#getBrand()
     */
    @Override
    public String getBrand() {
        return myBrand;
    }

    /** 
     * 
     * @see com.huoli.checkin.design.spring.ioc.Car#run()
     */
    @Override
    public void run() {
        System.out.println(myBrand + " is running!");
    }

}
