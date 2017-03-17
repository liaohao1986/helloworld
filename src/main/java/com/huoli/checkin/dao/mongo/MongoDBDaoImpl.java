/**
 * 
 */
package com.huoli.checkin.dao.mongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
@Component
public class MongoDBDaoImpl implements MongoDBDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public <T> T findOne(Class<T> clazz, Query query) {
        return mongoTemplate.findOne(query, clazz);
    }

    @Override
    public void save(Object obj) {
        mongoTemplate.save(obj);
    }

    @Override
    public <T> List<T> findAll(Class<T> clazz) {
        return mongoTemplate.findAll(clazz);
    }

    @Override
    public <T> T findById(Class<T> clazz, Object id) {
        return mongoTemplate.findById(id, clazz);
    }

    @Override
    public <T> List<T> find(Class<T> clazz, Query query) {
        return mongoTemplate.find(query, clazz);
    }

    @Override
    public <T> List<T> findList(Class<T> clazz, Query query, int currentPage, int pageSize) {
        //计算起始位置
        int startIndex = ((currentPage - 1) < 0 ? 0 : (currentPage - 1)) * pageSize;
        query.skip(startIndex);
        query.limit(pageSize);
        return mongoTemplate.find(query, clazz);
    }

    @Override
    public <T> long findCount(Class<T> clazz, Query query) {
        return mongoTemplate.count(query, clazz);
    }

    @Override
    public <T> int update(Query query, Update update, Class<T> clazz) {
        return mongoTemplate.updateFirst(query, update, clazz).getN();
    }

}
