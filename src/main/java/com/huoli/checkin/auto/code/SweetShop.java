/**
 * 
 */
package com.huoli.checkin.auto.code;

/**
 * @author Administrator
 *
 */
public class SweetShop {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.huoli.checkin.auto.code.Gum");
			Gum gum = (Gum) Class.forName("com.huoli.checkin.auto.code.Gum").newInstance();
			gum.print();
		} catch (ClassNotFoundException e) {
			System.out.println("Couldn't find Gum");
		}
		
		System.out.println("After Class.forName(\"Gum\")");
	}
}
