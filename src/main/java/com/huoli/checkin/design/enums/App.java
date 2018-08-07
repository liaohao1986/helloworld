/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.design.enums;

import java.util.ArrayList;
import java.util.Map;

import com.google.common.collect.Maps;

/**
 *
 * @author Administrator
 * @version $Id: App.java, v 0.1 2017年4月22日 下午8:37:24 Administrator Exp $
 */
public class App {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        double x = 10;
        double y = 2;
        for (Operation op : Operation.values()) {
            System.out.print(String.format("%f %s %f =%f%n", x, op, y, op.apply(x, y)));
        }
        Map<String, Object> map = Maps.newHashMap();
        map.put("123", "123");

    }

}
