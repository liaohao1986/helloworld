package com.huoli.checkin.dao;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huoli.checkin.entity.MailChannel;

public class MailChannelDaoTest {
    private static Logger logger = LoggerFactory.getLogger(MailChannelDaoTest.class);

    @Test
    public void test1() {
        MailChannelDao dao = (MailChannelDao) ContextHolder.applicationContext.getBean("mailChannelDao");
        MailChannel result = new MailChannel();
        result.setMailId(2);
        result.setChannelId(2);
        logger.debug("{}", dao.save(result));
    }
    
    @Test
    public void test2() {
        MailChannelDao dao = (MailChannelDao) ContextHolder.applicationContext.getBean("mailChannelDao");
        logger.debug("{}", dao.closeChannel("hnair-ffpcard"));
    }
}
