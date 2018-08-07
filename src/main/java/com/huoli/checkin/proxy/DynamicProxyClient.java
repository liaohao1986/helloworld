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
public class DynamicProxyClient {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        OrderService target = new OrderServiceImpl();
        OrderService orderService = (OrderService) (new DefaultDynamicProxyFactory().createAopProxy(target)).getProxy(target);
        orderService.searchOrder("170541245884490");
        
        OrderServiceCGLib target2 = new OrderServiceCGLib();
        OrderServiceCGLib orderService2 = (OrderServiceCGLib) (new DefaultDynamicProxyFactory().createAopProxy(target2)).getProxy(target2);
        orderService2.searchOrder("170541245884490");
//                OrderService orderService = (OrderService) new OrderServiceJdkDynamicProxy().getProxy(new OrderServiceImpl());
//        OrderService orderService = (OrderService) new OrderServiceCGLibDynamicProxy().getProxy(new OrderServiceImpl());
//                orderService.createOrder();
//                orderService.searchOrder("170541245884490");

        //OrderServiceCGLib orderService = (OrderServiceCGLib) new OrderServiceJdkDynamicProxy().getProxy(new OrderServiceCGLib());
//        orderService.searchOrder("170541245884490");
        //        orderService.deleteOrder();
    }

}
