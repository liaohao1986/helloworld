/**
 * 
 */
package com.huoli.checkin.design.pattern.guava;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年6月6日<br>
 */
public class ApacheCollectionsTest {

    /**
     *
     * @param args
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String> list1 = Lists.newArrayList();
        list1.add("123");
        list1.add("567");
        list1.add("789");

        List<String> list2 = Lists.newArrayList();
        list2.add("123");
        list2.add("456");
        list2.add("234");

        List<String> mergeList = (List<String>) CollectionUtils.intersection(list1, list2);
        List<String> unionList = (List<String>) CollectionUtils.union(list1, list2);
        List<String> disjunctionList = (List<String>) CollectionUtils.disjunction(list1, list2);
        List<String> subtractList = (List<String>) CollectionUtils.subtract(list1, list2);
        //        System.out.println(JSON.toJSONString(mergeList));
        //        System.out.println(JSON.toJSONString(unionList));
        //        System.out.println(JSON.toJSONString(disjunctionList));
        //        System.out.println(JSON.toJSONString(subtractList));
        //        System.out.println(list1.size());

        ImmutableList<String> list = ImmutableList.of("a", "b", "c", "d");
        //        for (String string : list) {
        //            System.out.println(string);
        //        }

        String[] subdirs = { "usr", "local", "lib" };
        String directory = Joiner.on("/").join(subdirs);
        System.out.println(directory);
        System.out.println(StringUtils.join(subdirs, "/"));
        System.out.println(JSON.toJSONString(StringUtils.split(directory, "/")));

    }

}
