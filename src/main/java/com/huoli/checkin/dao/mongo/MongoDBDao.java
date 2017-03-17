/**
 * 
 */
package com.huoli.checkin.dao.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
public interface MongoDBDao {

    void save(Object obj);

    <T> T findOne(Class<T> clazz, Query query);

    <T> List<T> findAll(Class<T> clazz);

    <T> T findById(Class<T> clazz, Object id);

    <T> List<T> find(Class<T> clazz, Query query);

    <T> List<T> findList(Class<T> clazz, Query query, int currentPage, int pageSize);

    <T> long findCount(Class<T> clazz, Query query);

    <T> int update(Query query, Update update, Class<T> clazz);
}
