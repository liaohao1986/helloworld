/**
 * 
 */
package com.huoli.checkin.dao.mongo;

import java.util.List;
import java.util.Map;

import org.springframework.data.mongodb.core.query.Query;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
public interface MongoBase<T> {
    //添加  
    public void insert(T object, String collectionName);

    //根据条件查找  
    public T findOne(Map<String, Object> params, String collectionName);

    //根据条件查找  
    public T findOne(Query query, String collectionName);
    
    //查找所有  
    public List<T> findAll(Map<String, Object> params);
    
    //查找所有  
    public List<T> findAll(Map<String, Object> params, String collectionName);

    //查找所有  
    public List<T> findAll(Query query, String collectionName);

    //修改  
    public void update(Map<String, Object> params, String collectionName);

    //创建集合  
    public void createCollection(String collectionName);

    //根据条件删除  
    public void remove(Map<String, Object> params, String collectionName);
}
