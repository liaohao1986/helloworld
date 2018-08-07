/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.design.enums;

/**
 *
 * @author Administrator
 * @version $Id: Parser.java, v 0.1 2017年5月1日 下午5:43:03 Administrator Exp $
 */
public interface Parser {

    void parse();

    default void test() {
        System.out.println("123");
    }
}
