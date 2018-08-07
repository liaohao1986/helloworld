/**
 * 
 */
package com.huoli.checkin.strategy;

/**
 * @author Administrator
 *
 */
public class PrimaryMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double bookPrice) {
		System.out.println("对于初级会员的没有折扣");
		return bookPrice;
	}

}
