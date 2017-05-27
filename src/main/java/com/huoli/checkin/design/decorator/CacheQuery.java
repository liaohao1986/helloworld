/**
 * 
 */
package com.huoli.checkin.design.decorator;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月24日<br>
 */
public class CacheQuery implements Query {

    private Map<String, Result> cache = Maps.newHashMap();

    private Query query;

    /**
     * @param query
     */
    public CacheQuery(Query query) {
        this.query = query;
    }

    /** 
     * @param sql
     * @return
     * @see com.huoli.checkin.design.decorator.Query#query(java.lang.String)
     */
    @Override
    public Result query(String sql) {
        System.out.println("缓存查询方式,sql=" + sql);
        if (cache.containsKey(sql)) {
            System.out.println("已查询到缓存");
            return cache.get(sql);
        }
        Result result = query.query(sql);
        cache.put(sql, result);
        return result;
    }
}
