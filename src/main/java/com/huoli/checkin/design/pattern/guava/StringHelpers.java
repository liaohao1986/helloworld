/**
 * 
 */
package com.huoli.checkin.design.pattern.guava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.google.common.base.Joiner;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年5月27日<br>
 */
public class StringHelpers {

    public static String toCommaSeparatedString(List<String> strings) {
        String result = "";
        if (strings != null && !strings.isEmpty()) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < strings.size(); i++) {
                String string = strings.get(i);
                if (string != null) {
                    stringBuilder.append(string);
                    stringBuilder.append(",");
                }
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            result = stringBuilder.toString();
        }
        return result;
    }

    public static List<String> fromCommaSeparatedString(String string) {
        List<String> strings = new ArrayList<String>();
        String[] splitted = string.split(",");
        for (int i = 0; i < splitted.length; i++) {
            String element = splitted[i].trim();
            strings.add(element);
        }
        return strings;
    }

    public static String toCommaSeparatedStringV2(List<String> strings) {
        Joiner joiner = Joiner.on(";").skipNulls();
        return joiner.join(strings);
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        System.out.println(StringUtils.join(list, ","));
        System.out.println(toCommaSeparatedString(list));
        System.out.println(toCommaSeparatedStringV2(list));
    }
}
