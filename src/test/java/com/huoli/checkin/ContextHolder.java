package com.huoli.checkin;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextHolder {
	public static ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath*:app-*.xml");
}
