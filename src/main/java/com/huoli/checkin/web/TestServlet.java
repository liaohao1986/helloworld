package com.huoli.checkin.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
public class TestServlet {

    @RequestMapping("/hello-world/timestamp")
    public Object convertPostData(String contextString) {
        SimpleResult result = SimpleResult.getSuccessResult();
        result.put("timestamp", System.currentTimeMillis() + "");
        return result;
    }

}
