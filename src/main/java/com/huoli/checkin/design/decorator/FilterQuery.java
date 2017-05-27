/**
 * 
 */
package com.huoli.checkin.design.decorator;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年4月24日<br>
 */
public class FilterQuery implements Query {
    private List<String> words = Lists.newArrayList();

    private Query query;

    /**
     * @param query
     */
    public FilterQuery(Query query) {
        this.query = query;
        words.add("1=1");
    }

    /** 
     * @param sql
     * @return
     * @see com.huoli.checkin.design.decorator.Query#query(java.lang.String)
     */
    @Override
    public Result query(String sql) {
        if (sql.contains("1=1")) {
            return null;
        }
        return query.query(sql);
    }
}
