/**
 * 
 */
package com.huoli.checkin.design.decorator;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月24日<br>
 */
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        Query query = new SimpleQuery();
        Query cacheQuery = new CacheQuery(query);
        System.out.println("---------------------1---------------------");
        cacheQuery.query("select * from checkin;");
        System.out.println("---------------------2---------------------");
        cacheQuery.query("select * from checkin;");

    }

}
