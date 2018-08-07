/**
 * 
 */
package com.huoli.checkin.convert;

/**
 * @author Administrator
 *
 */
public interface DTOConvert<S, T> {

	public T convert(S s);

}
