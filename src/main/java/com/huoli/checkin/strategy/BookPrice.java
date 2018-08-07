/**
 * 
 */
package com.huoli.checkin.strategy;

/**
 * @author Administrator
 *
 */
public class BookPrice {

	// 持有一个具体的策略对象
	private MemberStrategy strategy;

	/**
	 * 构造函数，传入一个具体的策略对象
	 * 
	 * @param strategy
	 *            具体的策略对象
	 */
	public BookPrice(MemberStrategy strategy) {
		this.strategy = strategy;
	}

	/**
	 * 计算图书的价格
	 * 
	 * @param bookPrice
	 *            图书的原价
	 * @return 计算出打折后的价格
	 */
	public double quote(double bookPrice) {
		return this.strategy.calcPrice(bookPrice);
	}
}
