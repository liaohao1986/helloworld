package com.huoli.checkin.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 调用的环绕通知 <br>
 * 版权：Copyright (c) 2011-2015<br>
 * 公司：北京活力天汇<br>
 * 作者：童凡<br>
 * 版本：1.0<br>
 * 创建日期：2015年6月30日<br>
 */
@Component
@Aspect
public class WebInvokeAdvice {
	private static Logger logger = LoggerFactory.getLogger(WebInvokeAdvice.class);

	/** 调用次数日志记录 */

	// 声明切入点
	@Pointcut("execution(* com.huoli.checkin.web.*Servlet.*(..))")
	public void anyMethod() {
	};
	
	@SuppressWarnings("rawtypes")
	private void invodeBefore(Class clazz, String methodName, Object[] args) {
		logger.info("接受{}请求,参数:{}", clazz.getName() + "." + methodName, Arrays.toString(args));
	}

	@SuppressWarnings("rawtypes")
	private void invokeEnd(Class clazz, String methodName, Object[] args, Object returnObject, long timeSpend) {
		logger.info("完成{}请求,参数:{},返回:{},耗时:{}", clazz.getName() + "." + methodName, args, returnObject, timeSpend);
	}

	// 环绕通知
	@Around("anyMethod()")
	public Object doprocess(ProceedingJoinPoint pjp) throws Throwable {
		invodeBefore(pjp.getTarget().getClass(), pjp.getSignature().getName(), pjp.getArgs());
		long start = System.currentTimeMillis();
		Object o = null;
		try {
			o = pjp.proceed();
		} catch (Exception e) {
			logger.error("ERROR", e);
			throw e;
		}

		long end = System.currentTimeMillis();
		invokeEnd(pjp.getTarget().getClass(), pjp.getSignature().getName(), pjp.getArgs(), o, end - start);
		return o;
	}
}
