/**
 * 
 */
package com.huoli.checkin.proxy;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月23日<br>
 */
public class OrderServiceCGLib {

    public void createOrder() {
        System.out.println("执行创建订单操作");
    }

    public void searchOrder(String orderId) {
        System.out.println("执行查询订单操作,orderId=" + orderId);
    }

    public void deleteOrder() {
        System.out.println("执行删除订单操作");
    }

}
