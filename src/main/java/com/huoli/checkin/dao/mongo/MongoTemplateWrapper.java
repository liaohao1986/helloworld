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
 * MongoTemplate包装类 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
@Component
public class MongoTemplateWrapper<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    public T findOne(Query query, Class<T> entityClass, String collectionName) {
        return (T) mongoTemplate.findOne(query, entityClass, collectionName);
    }

    public List<T> findAll(Query query, Class<T> entityClass) {
        return mongoTemplate.find(query, entityClass);
    }

    public List<T> findAll(Query query, Class<T> entityClass, String collectionName) {
        return mongoTemplate.find(query, entityClass, collectionName);
    }

    public void insert(CheckinResult objectToSave) {
        mongoTemplate.insert(objectToSave);
    }

    public T findOne(Map<String, Object> params, Class<T> entityClass, String collectionName) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return findOne(new Query(criteria), entityClass, collectionName);
    }

    public List<T> findAll(Map<String, Object> params, Class<T> entityClass) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return findAll(new Query(criteria), entityClass);
    }

    public List<T> findAll(Map<String, Object> params, Class<T> entityClass, String collectionName) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return findAll(new Query(criteria), entityClass, collectionName);
    }

    public long count(Query query, Class<T> entityClass) {
        return mongoTemplate.count(query, entityClass);
    }

    public List<T> findList(Class<T> entityClass, Query query, int currentPage, int pageSize) {
        //计算起始位置
        int startIndex = ((currentPage - 1) < 0 ? 0 : (currentPage - 1)) * pageSize;
        query.skip(startIndex);
        query.limit(pageSize);
        return mongoTemplate.find(query, entityClass);
    }

}
