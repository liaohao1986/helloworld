/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.jvm;

import java.util.ArrayList;
import java.util.List;

/** 
 * 运行时常量池的内存溢出 
 * -XX:PermSize=10M -XX:MaxPermSize=10M 
 * @author Nicholas 
 * Java 8 已经将永久代从方法区移除 
 */

/** 
 * intern() 是一个native 方法 
 *  如果字符串常量池中已经包含一个等于此string对象的字符串，则返回次string对象的引用 
 */
public class RuntimeConstantPoolOOM {

    public static void testIntern() {
        String string1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(string1 == string1.intern());

        String string2 = new StringBuilder("ja").append("va").toString();
        System.out.println(string2 == string2.intern());
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();

        int i = 0;
        while (true) {
            System.out.println(i);
//            list.add(String.valueOf(i++).intern());
            testIntern();
            list.add(String.valueOf(i++).intern());
        }
    }
}
