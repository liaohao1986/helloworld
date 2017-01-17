package com.huoli.checkin.register.airasia;

import java.io.IOException;

import org.junit.Test;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.huoli.httptask.HttpTask;

/**
 * 描述：自动注册脚本测试<br>
 * 版权：Copyright (c) 2011<br>
 * 公司：北京活力天汇<br>
 * 作者：彭德伟<br>
 * 版本：1.0<br>
 * 创建日期：2016年12月1日<br>
 */
public class ConfigTest {

	private HttpTask httpTask;

	/**
	 * 初始化HttpTask对象
	 * 
	 * @param config
	 * @throws IOException
	 */
	public void init(String config) throws IOException {
		//System.setProperty("jsse.enableSNIExtension", "false");
		String content = Resources.toString(Resources.getResource(config), Charsets.UTF_8);
		httpTask = new HttpTask(content, "127.0.0.1", 8888);
	}
	
	@Test
	public void testAKFfpcard() throws Exception {
		init("config/ffpcard/AK_register.json");
		//注册--初始密码默认为Huoli123
		httpTask.getContext().put("email", "pengdw9527@163.com");//邮箱
		httpTask.sendRequest("register");
		//从新发送激活邮件
//		httpTask.getContext().put("email", "pengdw9527@163.com");//邮箱
//		httpTask.sendRequest("resend_email");
	}
	
	   
    @Test
    public void testAKFfpcard2() throws Exception {
        init("config/ffpcard/AK_register.json");//mhryho359640
        //注册--初始密码默认为Huoli123
        httpTask.getContext().put("username", "aipdz344917");//邮箱
        httpTask.getContext().put("email", "mhryho359640@maopao.com");//邮箱
//        httpTask.sendRequest("active");
        httpTask.sendRequest("send_weixin_alarm");
        //从新发送激活邮件
//      httpTask.getContext().put("email", "pengdw9527@163.com");//邮箱
//      httpTask.sendRequest("resend_email");
    }
    
    
}
