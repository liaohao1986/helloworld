package com.huoli.checkin.design.cache;

import java.util.List;

import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;

public class CacheUtil {
    private static CacheBuilder<Object, Object> builder = CacheBuilder.newBuilder();

    public static <T> LoadingCache<String, T> newBuildCache() {
        return builder.build(new CacheLoader<String, T>() {
            public T load(String key) throws Exception {
                return null;
            }
        });
    }

    public static void main(String[] args) {
        LoadingCache<String, String> cache = CacheUtil.newBuildCache();
    }

    @Test
    public void TestLoadingCache() throws Exception {
        LoadingCache<String, String> cahceBuilder = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                String strProValue = "hello " + key + "!";
                return strProValue;
            }

        });

        String str1 = cahceBuilder.get("jerry");
        System.out.println("jerry value:" + str1);
        String str2 = cahceBuilder.getUnchecked("jerry");
        System.out.println("jerry value:" + str2);
        System.out.println(str1 == str2);
        System.out.println("peida value:" + cahceBuilder.get("peida"));
        System.out.println("peida value:" + cahceBuilder.get("peida"));
        System.out.println("lisa value:" + cahceBuilder.getUnchecked("lisa"));
        cahceBuilder.put("harry", "ssdded");
        System.out.println("harry value:" + cahceBuilder.get("harry"));

        List<String> list = Lists.newArrayList(); //编译器会自动转化。  ;
//        list = list == null ? Collections.emptyList() : list;
        list.add("123");
        for (String str : list) {
            System.out.println(str);
        }
    }
}
