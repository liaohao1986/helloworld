/**
 * 
 */
package com.huoli.checkin.result;


/**
 * @author Administrator
 *
 */
public class TestResult {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EbookResult<Boolean> result = new EbookResultSupport<Boolean>(false);
		
		EbookResult<Boolean> result2 = result.getFailResult(TopResultCode.isv_missing_parameter);
		System.out.println(result2);
	}

}
