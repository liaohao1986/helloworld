/**
 * 
 */
package com.huoli.checkin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.huoli.checkin.dao.mongo.MongoDBDao;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */

@Service
public class MongoDBServiceImpl implements MongoDBService {

    @Autowired
    private MongoDBDao mongoDBDao;

    @Override
    public void save(Object obj) {
        mongoDBDao.save(obj);
    }

    @Override
    public <T> T findOne(Class<T> clazz, Query query) {
        return mongoDBDao.findOne(clazz, query);
    }

    @Override
    public <T> List<T> findAll(Class<T> clazz) {
        return mongoDBDao.findAll(clazz);
    }

    @Override
    public <T> List<T> find(Class<T> clazz, Query query) {
        return mongoDBDao.find(clazz, query);
    }

    //    @Override
    //    public <T> Pagination<T> getPagination(Class<T> clazz, Query query, int currentPage, int pageSize) {
    //        List<T> recordList = mongoDBDao.findList(clazz, query, currentPage, pageSize);
    //        long recordCount = mongoDBDao.findCount(clazz, query);
    //        return new Pagination<T>(currentPage, pageSize, recordCount, recordList);
    //    }

    @Override
    public <T> int update(Query query, Update update, Class<T> clazz) {
        return mongoDBDao.update(query, update, clazz);
    }

}
