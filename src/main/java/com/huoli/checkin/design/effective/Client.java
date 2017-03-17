/**
 * 
 */
package com.huoli.checkin.design.effective;

import java.util.Arrays;

import com.alibaba.fastjson.JSON;

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

        //        Figure circle = new Circle(3f);
        //        Figure rectangle = new Rectangle(3f, 4f);
        //        Figure Square = new Square(3f);
        //        System.out.println(circle.area());
        //        System.out.println(rectangle.area());
        //        System.out.println(Square.area());
        String[] stringArray = { "ab", "b", "c", "Ab" };
        Arrays.sort(stringArray, String.CASE_INSENSITIVE_ORDER);
        System.out.println(JSON.toJSONString(stringArray));
    }

}
