/**
 * 
 */
package com.huoli.checkin.jdbc;

import java.util.Set;

import com.huoli.utils.DateTimeUtil;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月17日<br>
 */
public class MongoDBJDBC3 {
    public static void main(String[] args) {
        MongoClient mongoClient = null;
        try {
            mongoClient = new MongoClient(new MongoClientURI("mongodb://checkin:ChePas92@120.133.0.162:27017/admin"));
            DB db = mongoClient.getDB("checkin");

            //设置Where条件  </div>
            DBObject match = new BasicDBObject("$match", new BasicDBObject("sysDate",
                (new BasicDBObject("$gt", DateTimeUtil.getYesterday())).append("$lt", DateTimeUtil.getToday())));
            //设置分组字段    
            DBObject project = new BasicDBObject("$project", new BasicDBObject("_id", "0").append("airline", "1").append("flightNo", "1").append("resultError", "1")
                .append("successTip", "1").append("operation", "1").append("action", "1").append("client", "1"));

            //            List<DBObject> list=(List<DBObject>)dbc.aggregate(match,project).results();  
            //            List<DBObject> list = (List<DBObject>) db.getCollection("checkin_result").aggregate(match, project).results();
            //            System.out.println(list.size());
            Set<String> collectionNameIterable = db.getCollectionNames();
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
