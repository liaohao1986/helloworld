package com.huoli.checkin.convert;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.huoli.checkin.res.SimpleResult;

/**
 * 海航常旅客注册转换器 <br>
 * 版权：Copyright (c) 2011-2016<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2016年11月29日<br>
 */
@Component
public class FFPCardHuConverter {
    private static Logger       logger             = LoggerFactory.getLogger(FFPCardHuConverter.class);
    // 省-城市列表 格式：湖北-武汉
    private static List<String> proviceAndCityList = new ArrayList<String>();
    private static Random       random             = new Random();

    static {
        proviceAndCityList.add("福建-福州");
        proviceAndCityList.add("甘肃-兰州");
        proviceAndCityList.add("河北-石家庄");
        proviceAndCityList.add("河南-郑州");
        proviceAndCityList.add("黑龙江-哈尔滨");
        proviceAndCityList.add("湖南-长沙");
        proviceAndCityList.add("湖北-武汉");
        proviceAndCityList.add("吉林-长春");
        proviceAndCityList.add("江苏-南京");
        proviceAndCityList.add("江西-南昌");
        proviceAndCityList.add("辽宁-沈阳");
        proviceAndCityList.add("山东-济南");
        proviceAndCityList.add("山西-太原");
        proviceAndCityList.add("陕西-西安");
        proviceAndCityList.add("四川-成都");
        proviceAndCityList.add("浙江-杭州");
        proviceAndCityList.add("云南-昆明");
    }

    /**
     * 将上下文的变量转换成post data数据
     *
     * @param contextString
     * @return
     */
    public SimpleResult convert(String contextString) {
        if (StringUtils.isBlank(contextString)) {
            return SimpleResult.getFailResult("上线文内容为空");
        }
        try {
            logger.debug("contextString:{}", contextString);
            SimpleResult result = SimpleResult.getSuccessResult();
            result.put("postData", getPostDataFromContext(contextString));
            return result;
        } catch (Exception e) {
            logger.error("Exception", e);
            return SimpleResult.getFailResult("程序异常");
        }
    }

    private String getPostDataFromContext(String contextString) throws Exception {
        JSONObject context = JSON.parseObject(contextString);
        StringBuilder builder = new StringBuilder("");
        builder.append("gender=").append(context.get("gender"));
        builder.append("&firstName=").append(java.net.URLEncoder.encode((String) context.get("firstName"), "utf-8"));
        builder.append("&lastName=").append(java.net.URLEncoder.encode((String) context.get("lastName"), "utf-8"));
        builder.append("&firstNamePy=").append(context.get("firstNamePy"));
        builder.append("&lastNamePy=").append(context.get("lastNamePy"));
        builder.append("&nationality=CN&cType=ID&cNumber=").append(context.get("idcard"));
        builder.append("&sex=").append(context.get("gender"));
        builder.append("&birthday=").append(context.get("birthday"));
        builder.append("&password=").append(context.get("ffpcardPassword")).append("&confirmPass=").append(context.get("ffpcardPassword"))
            .append("&pwdq=&customQ=&pwda=&pID=&pName=&email=").append(java.net.URLEncoder.encode((String) context.get("email"), "utf-8"));
        builder.append("&mobile=").append(context.get("mobile"));
        builder.append("&addressMode=2&homeCountry=CN&homeProvince=&homeCity=&homeAddress=&homeZipCode=&homePhone=&workCountry=CN");
        String proviceAndCity = proviceAndCityList.get(random.nextInt(proviceAndCityList.size()));
        String[] proviceAndCityArr = proviceAndCity.split("-");
        builder.append("&workProvince=").append(java.net.URLEncoder.encode(proviceAndCityArr[0], "utf-8"));
        builder.append("&workCity=").append(java.net.URLEncoder.encode(proviceAndCityArr[1], "utf-8"));
        builder.append("&workAddress=&workZipCode=&workName=&workPost=&workPhone=&language=CN&isSubEmail=Y&validateCodeImg=").append(context.get("verifyCode"));
        builder.append("&validateType=1&validateCode=").append(context.get("emailVerifyCode"));
        return builder.toString();
    }
}
