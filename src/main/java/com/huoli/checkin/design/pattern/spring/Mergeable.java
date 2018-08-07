/**
 * 
 */
package com.huoli.checkin.design.pattern.spring;

/**
 * @author Administrator
 *
 */
public interface Mergeable {

	boolean isMergeable();

	Object merge(Object parent);

}
