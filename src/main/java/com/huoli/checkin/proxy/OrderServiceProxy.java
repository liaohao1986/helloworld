///**
// * 
// */
//package com.huoli.checkin.proxy;
//
///**
// * TODO:简单描述这个类的含义 <br>
// * 版权：Copyright (c) 2011-2017<br>
// * 公司：北京活力天汇<br>
// * 版本：1.0<br>
// * 作者：廖浩<br>
// * 创建日期：2017年2月23日<br>
// */
//public class OrderServiceProxy implements OrderService {
//
//    private OrderService orderService;
//
//    public OrderServiceProxy(OrderService orderService) {
//        this.orderService = orderService;
//    }
//
//    /** 
//     * 
//     * @see com.huoli.checkin.proxy.OrderService#createOrder()
//     */
//    @Override
//    public void createOrder() {
//        System.out.println("执行下单权限校验");
//        System.out.println("执行下单检查");
//        orderService.createOrder();
//    }
//
//    @Override
//    public void searchOrder() {
//    }
//
//}
