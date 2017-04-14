/**
 * 
 */
package com.huoli.checkin.design.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类级 右边栏
 * User: Alec
 * Date: 13-3-15
 * Time: 下午2:52
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RSidebar {
}