/**
 * 
 */
package com.huoli.checkin.effective;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月2日<br>
 */
public class Client {

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber(1, 2, 3);
        Map<PhoneNumber, String> hashMap = new HashMap<PhoneNumber, String>();
        hashMap.put(phoneNumber, "liaohao");
        PhoneNumber phoneNumber2 = new PhoneNumber(1, 2, 3);
        PhoneNumber phoneNumber3 = new PhoneNumber(1, 2, 3);
        hashMap.put(phoneNumber2, "liaohao2");
        hashMap.put(phoneNumber3, "liaohao3");
        System.out.println(phoneNumber.hashCode());
        System.out.println(ToStringBuilder.reflectionToString(hashMap));
        System.out.println(hashMap.size());
        System.out.println(phoneNumber2.hashCode());
        System.out.println(phoneNumber3.hashCode());
        System.out.println(hashMap.get(phoneNumber2));
    }
}
