/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.util;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Administrator
 * @version $Id: StringUtil.java, v 0.1 2017年3月13日 上午11:23:50 Administrator Exp $
 */
public class StringUtil {

    /**
     * 
     */
    private StringUtil() {
        // TODO Auto-generated constructor stub
    }

    public static boolean isBlank(String str) {
        return StringUtils.isBlank(str);
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setAge(30);
        person.setName("liaohao");
        Person person2 = (Person) person.clone();
        person2.setName("lilin");
        person2.setAge(26);
        System.out.println("person:" + person);
        System.out.println("person2:" + person2);
    }
}
