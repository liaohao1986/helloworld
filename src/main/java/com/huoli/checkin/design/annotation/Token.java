/**
 * 
 */
package com.huoli.checkin.design.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 方法级 创建Token
 * User: Alec
 * Date: 13-3-15
 * Time: 下午2:16
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Token {

}
