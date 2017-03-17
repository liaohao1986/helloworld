/**
 * 
 */
package com.huoli.checkin.jdbc;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
public class MongoDBJDBC2 {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://checkin:ChePas92@120.133.0.162:27017/admin"));
            MongoDatabase db = mongoClient.getDatabase("checkin");
            MongoIterable<String> collectionNameIterable = db.listCollectionNames();
            for (String collectionName : collectionNameIterable) {
                System.out.println(collectionName);
            }
            //连接到数据库    
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        } finally {
            if (mongoClient != null) {
                mongoClient.close();
            }
        }
    }
}
