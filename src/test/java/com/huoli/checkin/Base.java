/**
 * 
 */
package com.huoli.checkin;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月14日<br>
 */
public class Base {
    public static void unbounded(List<?> list) {
    }

    public static void upBounded(List<? extends Object> list) {
    }

    public static void main(String args[]) {
        List<?> list1 = new ArrayList<Object>();
        List<? extends Object> list2 = new ArrayList<Object>();

        unbounded(list2);
        upBounded(list1);
    }
}
