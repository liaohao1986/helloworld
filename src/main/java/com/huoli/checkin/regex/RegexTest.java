/**
 * 
 */
package com.huoli.checkin.regex;

import java.util.List;

import com.huoli.httptask.Utils;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月27日<br>
 */
public class RegexTest {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "张三李四2016年10月12日";
        //        String exp = "(?=).*?(?=年)";
        String exp = "\\d+";
        List<String> resultList = Utils.findMatches(str, exp);
        for (String result : resultList) {
            System.out.println("正则匹配结果:" + result);
        }

    }
}
