package com.huoli.checkin.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.huoli.checkin.convert.FFPCardHuConverter;
import com.huoli.checkin.res.SimpleResult;

/**
 * 自动注册帮助类 <br>
 * 版权：Copyright (c) 2011-2016<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2016年11月29日<br>
 */
@Controller
public class AutoRegisterServlet {
    private static Logger      logger = LoggerFactory.getLogger(AutoRegisterServlet.class);

    @Autowired
    private FFPCardHuConverter ffpCardHuConverter;

    @RequestMapping("/auto-register/ffpcard/hu/get_post_data")
    public Object convertPostData(String contextString) {
        SimpleResult result = ffpCardHuConverter.convert(contextString);
        logger.debug("{}", result);
        return result;
    }

}
