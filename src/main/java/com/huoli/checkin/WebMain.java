package com.huoli.checkin;

import java.io.File;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppClassLoader;
import org.eclipse.jetty.webapp.WebAppContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;

/**
 * 描述：Web入口类<br>
 * 版权：Copyright (c) 2011<br>
 * 公司：北京活力天汇<br>
 * 作者：童凡<br>
 * 版本：1.0<br>
 * 创建日期：2014-1-29<br>
 */
public class WebMain {
	private static Logger logger = LoggerFactory.getLogger(WebMain.class);
	public static ApplicationContext appContext;

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) {
		try {
			logger.info("准备加载程序");
			File dir = new ClassPathResource("").getFile();
			logger.info(dir.toString());

			appContext = new ClassPathXmlApplicationContext("app-*.xml");
			Server jettyServer = (Server) appContext.getBean("jettyServer");
			WebAppContext webAppContext = (WebAppContext) jettyServer.getHandler();
			// webAppContext.setClassLoader(appContext.getClassLoader());

			// 使用JSTL
			webAppContext.setClassLoader(new WebAppClassLoader(WebMain.class.getClassLoader(), webAppContext));

			XmlWebApplicationContext xmlWebAppContext = new XmlWebApplicationContext();
			xmlWebAppContext.setParent(appContext);
			xmlWebAppContext.setConfigLocation("");
			xmlWebAppContext.setServletContext(webAppContext.getServletContext());
			xmlWebAppContext.refresh();
			webAppContext.setAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE, xmlWebAppContext);
			jettyServer.start();
			logger.info("加载完成");
		} catch (Exception e) {
			logger.error("主程序出错:", e);
		}

	}

}
