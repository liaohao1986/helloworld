/**
 * 
 */
package com.huoli.checkin.design.pattern.templete.bank;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年3月31日<br>
 */
public class App {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        Account currentAccount = new CurrentAccount();
        currentAccount.handle("张无忌", "123456");  
        
        Account cavingAccount = new SavingAccount();
        cavingAccount.handle("张无忌", "123456");  
    }

}
