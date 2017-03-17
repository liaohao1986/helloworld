package com.huoli.checkin.dao.mongo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
public abstract class AbstractDao<T> {
    
    /** 
     * @param params
     * @param collectionName
     * @return
     * @see com.huoli.checkin.dao.MongoBase#findOne(java.util.Map, java.lang.String)
     */
    public T findOne(Map<String, Object> params, String collectionName) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return findOne(new Query(criteria), collectionName);
    }

    /** 
     * @param params
     * @param collectionName
     * @return
     * @see com.huoli.checkin.dao.MongoBase#findOne(java.util.Map, java.lang.String)
     */
    public List<T> findAll(Map<String, Object> params) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return findAll(new Query(criteria));
    }

    /** 
     * @param params
     * @param collectionName
     * @return
     * @see com.huoli.checkin.dao.MongoBase#findAll(java.util.Map, java.lang.String)
     */
    public List<T> findAll(Map<String, Object> params, String collectionName) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return findAll(new Query(criteria), collectionName);
    }

    public abstract void insert(T objectToSave);
    public abstract T findOne(Query query, String collectionName);
    public abstract List<T> findAll(Query query);
    public abstract List<T> findAll(Query query, String collectionName);

    /** 
     * @param params
     * @param collectionName
     * @see com.huoli.checkin.dao.MongoBase#update(java.util.Map, java.lang.String)
     */
    public void update(Map<String, Object> params, String collectionName) {
    }

    /** 
     * @param collectionName
     * @see com.huoli.checkin.dao.MongoBase#createCollection(java.lang.String)
     */
    public void createCollection(String collectionName) {
    }

    /** 
     * @param params
     * @param collectionName
     * @see com.huoli.checkin.dao.MongoBase#remove(java.util.Map, java.lang.String)
     */
    public void remove(Map<String, Object> params, String collectionName) {
    }

}
