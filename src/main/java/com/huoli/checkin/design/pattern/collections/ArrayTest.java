/**
 * 
 */
package com.huoli.checkin.design.pattern.collections;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月20日<br>
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayTest {
    public static void main(String[] args) {

        List<Integer> lstint = new ArrayList<Integer>();
        lstint.add(1);
        lstint.add(2);
        lstint.add(3);

        // Iterator遍历一
        Iterator<Integer> iterator = lstint.iterator();
        while (iterator.hasNext()) {
            int i = (Integer) iterator.next();
            System.out.println(i);
        }

        // Iterator遍历二
        for (Iterator<Integer> it = lstint.iterator(); it.hasNext();) {
            int i = (Integer) it.next();
            System.out.println(i);
        }

        // for循环
        for (int i = 0; i < lstint.size(); i++) {
            System.out.println(lstint.get(i));
        }

        // for循环加强版
        for (Integer i : lstint) {
            System.out.println(i);
        }

    }

}
