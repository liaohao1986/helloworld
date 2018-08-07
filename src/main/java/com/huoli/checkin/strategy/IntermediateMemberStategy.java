/**
 * 
 */
package com.huoli.checkin.strategy;

/**
 * @author Administrator
 *
 */
public class IntermediateMemberStategy implements MemberStrategy {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.huoli.checkin.strategy.MemberStrategy#calcPrice(double)
	 */
	@Override
	public double calcPrice(double bookPrice) {
		System.out.println("对于中级会员的折扣为10%");
		return bookPrice * 0.9;
	}

}
