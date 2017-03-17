/**
 * 
 */
package com.huoli.checkin.design.pattern.collections;

import java.util.Arrays;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月3日<br>
 */
public class Client {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        InstrumentHashSet<String> set = new InstrumentHashSet<String>();
        set.addAll(Arrays.asList("1", "2", "3"));
        
//        set.add("1");
//        set.add("2");
//        set.add("3");
        System.out.println(set.getAddAcount());

    }

}
