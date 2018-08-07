/**
 * 
 */
package com.huoli.checkin.strategy;

/**
 * @author Administrator
 *
 */
public class AdvancedMemberStrategy implements MemberStrategy {

	@Override
	public double calcPrice(double bookPrice) {
		System.out.println("对于高级会员的折扣为20%");
		return bookPrice * 0.8;
	}

}
