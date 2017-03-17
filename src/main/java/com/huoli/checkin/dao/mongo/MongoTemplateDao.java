/**
 * 
 */
package com.huoli.checkin.dao.mongo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.huoli.checkin.entity.CheckinResult;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
@Component
public class MongoTemplateDao<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public T findOne(Query query, Class claszz, String collectionName) {
        return (T) mongoTemplate.findOne(query, claszz, collectionName);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<T> findAll(Query query, Class claszz) {
        return mongoTemplate.find(query, claszz);
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List<T> findAll(Query query, Class claszz, String collectionName) {
        return mongoTemplate.find(query, claszz, collectionName);
    }

    public void insert(CheckinResult objectToSave) {
        mongoTemplate.insert(objectToSave);
    }

    @SuppressWarnings({ "rawtypes" })
    public T findOne(Map<String, Object> params, Class claszz, String collectionName) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return findOne(new Query(criteria), claszz, collectionName);
    }

    @SuppressWarnings({ "rawtypes" })
    public List<T> findAll(Map<String, Object> params, Class claszz) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return findAll(new Query(criteria), claszz);
    }

    @SuppressWarnings({ "rawtypes" })
    public List<T> findAll(Map<String, Object> params, Class claszz, String collectionName) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return findAll(new Query(criteria), claszz, collectionName);
    }

    public List<T> findList(Class<T> clazz, Query query, int currentPage, int pageSize) {
        //计算起始位置
        int startIndex = ((currentPage - 1) < 0 ? 0 : (currentPage - 1)) * pageSize;
        query.skip(startIndex);
        query.limit(pageSize);
        return mongoTemplate.find(query, clazz);
    }

    public void update(Map<String, Object> params, String collectionName) {
    }

    public void createCollection(String collectionName) {
    }

    public void remove(Map<String, Object> params, String collectionName) {
    }

}
