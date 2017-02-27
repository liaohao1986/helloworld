/**
 * 
 */
package com.huoli.checkin.design.pattern.singleton;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月17日<br>
 */

public class MapTest {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < 2000000; i++) {
            map.put(i, "第" + i + "个");
        }
        //循环第一种  
        long t1 = System.nanoTime();
        Object key[] = map.keySet().toArray();
        for (int i = 0; i < map.size(); i++) {
            map.get(key[i]);
        }
        long t2 = System.nanoTime();
        //循环第二种  
        for (Entry<Integer, String> entry : map.entrySet()) {
            entry.getValue();
        }
        long t3 = System.nanoTime();
        //循环第三种  
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            Integer ii = (Integer) it.next();
            map.get(ii);
        }
        long t4 = System.nanoTime();
        //循环第四种  
        for (Integer kk : map.keySet()) {
            map.get(kk);
        }
        long t5 = System.nanoTime();
        System.out.println("第一种方法耗时：" + (t2 - t1) / 1000 + "微秒");
        System.out.println("第二种方法耗时：" + (t3 - t2) / 1000 + "微秒");
        System.out.println("第三种方法耗时：" + (t4 - t3) / 1000 + "微秒");
        System.out.println("第四种方法耗时：" + (t5 - t4) / 1000 + "微秒");
    }

}
