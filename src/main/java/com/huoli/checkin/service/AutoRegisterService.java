package com.huoli.checkin.service;

import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import com.alibaba.fastjson.JSON;
import com.huoli.checkin.dao.QueryAccountDao;
import com.huoli.checkin.entity.MailChannel;
import com.huoli.checkin.entity.QueryAccount;
import com.huoli.checkin.res.SimpleResult;
import com.huoli.httptask.HttpTask;
import com.huoli.proxy.entity.ProxyServer;
import com.huoli.proxy.service.ProxyService;

/**
 * 自动注册服务<br>
 * 版权：Copyright (c) 2011-2016<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2016年11月29日<br>
 */
public class AutoRegisterService {
    private static Logger        logger        = LoggerFactory.getLogger(AutoRegisterService.class);

    private static final int     SLEEP_SECONDS = 5;
    private ProxyService         proxyService;
    private QueryAccountDao      queryAccountDao;
    private String               configFile;
    /** action集合，key:action名称  value:重试次数*/
    private Map<String, Integer> actionMap;

    public SimpleResult execute(MailChannel mailChannel) {
        try {
            return register(mailChannel);
        } catch (Exception e) {
            logger.debug("Exception", e);
            return SimpleResult.getFailResult("注册失败");
        }
    }

    private SimpleResult register(MailChannel mailChannel) throws Exception {
        String configString = FileUtils.readFileToString(new ClassPathResource(configFile).getFile(), "utf-8");
        ProxyServer proxyServer = proxyService.getProxyServer();
        logger.debug("代理对象proxyServer:{}", JSON.toJSONString(proxyServer));
        HttpTask httpTask = new HttpTask(configString);
        httpTask.getContext().put("email", mailChannel.getMail());
        for (Entry<String, Integer> entry : actionMap.entrySet()) {
            logger.debug("action:{},重试次数:{}", entry.getKey(), entry.getValue());
            doAction(httpTask, entry.getKey(), entry.getValue());
            String resultError = (String) httpTask.getContext().get("resultError");
            String action = (String) httpTask.getContext().get("action");
            if (StringUtils.equals("register", action)) {
                break;
            }
            if (StringUtils.isNotBlank(resultError)) {
                return SimpleResult.getFailResult(resultError);
            }
            httpTask.getContext().put("contextString", JSON.toJSONString(httpTask.getContext()));
        }
        queryAccountDao.save(convert2QueryAccount(httpTask));
        return SimpleResult.getSuccessResult("注册成功");
    }

    private QueryAccount convert2QueryAccount(HttpTask httpTask) {
        QueryAccount queryAccount = new QueryAccount();
        queryAccount.setType((String) httpTask.getContext().get("type"));
        queryAccount.setUsername((String) httpTask.getContext().get("username"));
        queryAccount.setPassword((String) httpTask.getContext().get("password"));
        queryAccount.setName((String) httpTask.getContext().get("name"));
        queryAccount.setExtData((String) httpTask.getContext().get("extData"));
        return queryAccount;
    }

    private void doAction(HttpTask httpTask, String action, int maxRetryTimes) throws Exception {
        int retryTimes = 0;
        while (retryTimes <= maxRetryTimes) {
            retryTimes++;
            httpTask.sendRequest(action);
            String resultError = (String) httpTask.getContext().get("resultError");
            if (StringUtils.isBlank(resultError) || retryTimes > maxRetryTimes) {
                break;
            }
            logger.debug("重试次数, retryTimes:{}", retryTimes);
            httpTask.getContext().remove("resultError");
            Thread.sleep(SLEEP_SECONDS * 1000);
        }
    }

    public void setProxyService(ProxyService proxyService) {
        this.proxyService = proxyService;
    }

    public void setQueryAccountDao(QueryAccountDao queryAccountDao) {
        this.queryAccountDao = queryAccountDao;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    public void setActionMap(Map<String, Integer> actionMap) {
        this.actionMap = actionMap;
    }

}
