package com.huoli.checkin.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.huoli.checkin.dao.MailChannelDao;
import com.huoli.checkin.entity.MailChannel;
import com.huoli.checkin.res.SimpleResult;

/**
 * 自动注册请求分发<br>
 * 版权：Copyright (c) 2011-2016<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2016年11月29日<br>
 */
public class AutoRegisterServiceRouter {
    private static Logger                    logger = LoggerFactory.getLogger(AutoRegisterServiceRouter.class);

    private MailChannelDao                   mailChannelDao;

    private Map<String, AutoRegisterService> serviceMap;

    public SimpleResult register(String channel) throws Exception {
        AutoRegisterService service = serviceMap.get(channel);
        MailChannel mailChannel = mailChannelDao.querySingleUnusedEmailByChannel(channel);
        if (mailChannel == null) {
            return SimpleResult.getFailResult("找不到该渠道未使用的邮箱地址");
        }
        SimpleResult result = service.execute(mailChannel);
        logger.debug("注册结果，channel：{},result：{}", channel, result);
        return result;
    }

    public AutoRegisterService getService(String channel) {
        return serviceMap.get(channel);
    }

    public void setServiceMap(Map<String, AutoRegisterService> serviceMap) {
        this.serviceMap = serviceMap;
    }

    public void setMailChannelDao(MailChannelDao mailChannelDao) {
        this.mailChannelDao = mailChannelDao;
    }

}
