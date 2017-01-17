package com.huoli.checkin.task;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.alibaba.fastjson.JSON;
import com.huoli.checkin.dao.MailChannelDao;
import com.huoli.checkin.entity.MailChannel;
import com.huoli.checkin.res.SimpleResult;
import com.huoli.checkin.service.AutoRegisterService;
import com.huoli.checkin.service.AutoRegisterServiceRouter;

/**
 * 自动注册定时任务 <br>
 * 版权：Copyright (c) 2011-2016<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2016年11月28日<br>
 */
public class AutoRegisterTask {

    private Logger                    logger                   = LoggerFactory.getLogger(AutoRegisterTask.class);

    private ThreadPoolTaskExecutor    taskExecutor;

    private MailChannelDao            mailChannelDao;

    private AutoRegisterServiceRouter autoRegisterServiceRouter;

    private static AtomicInteger      activeCount              = new AtomicInteger(0);

    /** 正在处理的邮箱渠道，防止并发操作  key:"channel_mail" 渠道名称和邮箱 , value:时间戳*/
    private static Map<String, Long>  processingMailChannelMap = new ConcurrentHashMap<String, Long>();

    public void handle() {
        if (activeCount.get() > 3) {
            logger.debug("当前任务已经超过了正在处理的最大线程数3个");
            return;
        }
        clearExpriedMail();
        logger.debug("正在处理的自动注册线程数,activeCount:{},processingMailChannelMap:{}", activeCount, processingMailChannelMap);
        List<MailChannel> mailList = mailChannelDao.queryUnusedEmailList();
        if (CollectionUtils.isEmpty(mailList)) {
            logger.debug("未找到可使用的邮箱");
            return;
        }
        for (final MailChannel mailChannel : mailList) {
            final AutoRegisterService autoRegisterService = autoRegisterServiceRouter.getService(mailChannel.getChannel());
            if (autoRegisterService == null) {
                mailChannelDao.closeChannel(mailChannel.getChannel());
                logger.debug("未找到该渠道的注册类,mailChannel:{}", mailChannel);
                return;
            }
            taskExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    start(autoRegisterService, mailChannel);
                }
            });
        }
    }

    private void start(AutoRegisterService autoRegisterService, MailChannel mailChannel) {
        String key = String.format("%s_%s", mailChannel.getChannel(), mailChannel.getMail());
        if (processingMailChannelMap.get(key) != null) {
            logger.debug("当前任务正在处理该邮箱,mailChannel:{}", mailChannel);
            return;
        }
        processingMailChannelMap.put(key, System.currentTimeMillis());
        activeCount.getAndIncrement();
        logger.debug("自动注册任务开始,mailChannel:{}", JSON.toJSONString(mailChannel));
        SimpleResult result = autoRegisterService.execute(mailChannel);
        if (result.isSuccess()) {
            mailChannelDao.save(mailChannel);
        }
        activeCount.getAndDecrement();
        processingMailChannelMap.remove(key);
        logger.debug("自动注册任务结束");
    }

    /**
     * 清空处理过期的邮箱
     *
     */
    private void clearExpriedMail() {
        if (processingMailChannelMap.size() == 0) {
            return;
        }
        for (Entry<String, Long> entry : processingMailChannelMap.entrySet()) {
            long now = System.currentTimeMillis();
            long between = (now - entry.getValue()) / (1000 * 60);// 除以1000*60是为了转换成分
            if (between < 10) {
                continue;
            }
            processingMailChannelMap.remove(entry.getKey());
        }
    }

    public void setTaskExecutor(ThreadPoolTaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void setMailChannelDao(MailChannelDao mailChannelDao) {
        this.mailChannelDao = mailChannelDao;
    }

    public void setAutoRegisterServiceRouter(AutoRegisterServiceRouter autoRegisterServiceRouter) {
        this.autoRegisterServiceRouter = autoRegisterServiceRouter;
    }

}
