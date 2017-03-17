package com.huoli.checkin.dao.mongo;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.huoli.checkin.entity.AccountResult;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
@Component
public class AccountResultDao implements MongoBase<AccountResult> {
    @Autowired
    private MongoTemplate mongoTemplate;

    /** 
     * @param object
     * @param collectionName
     * @see com.huoli.checkin.dao.MongoBase#insert(java.lang.Object, java.lang.String)
     */
    @Override
    public void insert(AccountResult object, String collectionName) {
    }

    /** 
     * @param params
     * @param collectionName
     * @return
     * @see com.huoli.checkin.dao.MongoBase#findOne(java.util.Map, java.lang.String)
     */
    public AccountResult findOne(Map<String, Object> params, String collectionName) {
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
    @Override
    public AccountResult findOne(Query query, String collectionName) {
        return mongoTemplate.findOne(query, AccountResult.class, collectionName);
    }

    /** 
     * @param params
     * @param collectionName
     * @return
     * @see com.huoli.checkin.dao.MongoBase#findAll(java.util.Map, java.lang.String)
     */
    @Override
    public List<AccountResult> findAll(Map<String, Object> params) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return mongoTemplate.find(new Query(criteria), AccountResult.class);
    }

    /** 
     * @param params
     * @param collectionName
     * @return
     * @see com.huoli.checkin.dao.MongoBase#findAll(java.util.Map, java.lang.String)
     */
    @Override
    public List<AccountResult> findAll(Map<String, Object> params, String collectionName) {
        Criteria criteria = new Criteria();
        for (Entry<String, Object> entry : params.entrySet()) {
            criteria.andOperator(Criteria.where(entry.getKey()).is(entry.getValue()));
        }
        return findAll(new Query(criteria), collectionName);
    }

    /** 
     * @param params
     * @param collectionName
     * @return
     * @see com.huoli.checkin.dao.MongoBase#findAll(java.util.Map, java.lang.String)
     */
    @Override
    public List<AccountResult> findAll(Query query, String collectionName) {
        return mongoTemplate.find(query, AccountResult.class, collectionName);
    }

    /** 
     * @param params
     * @param collectionName
     * @see com.huoli.checkin.dao.MongoBase#update(java.util.Map, java.lang.String)
     */
    @Override
    public void update(Map<String, Object> params, String collectionName) {
    }

    /** 
     * @param collectionName
     * @see com.huoli.checkin.dao.MongoBase#createCollection(java.lang.String)
     */
    @Override
    public void createCollection(String collectionName) {
    }

    /** 
     * @param params
     * @param collectionName
     * @see com.huoli.checkin.dao.MongoBase#remove(java.util.Map, java.lang.String)
     */
    @Override
    public void remove(Map<String, Object> params, String collectionName) {
    }

}
