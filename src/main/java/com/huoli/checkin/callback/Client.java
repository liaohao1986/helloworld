/**
 * 
 */
package com.huoli.checkin.callback;

/**
 * TODO:简单描述这个类的含义 <br>
 * 版权：Copyright (c) 2011-2017<br>
 * 公司：北京活力天汇<br>
 * 版本：1.0<br>
 * 作者：廖浩<br>
 * 创建日期：2017年2月24日<br>
 */
public class Client {

    /**
     *
     * @param args
     */
    //    public static void main(String[] args) {
    //        /** 
    //         * new 一个小李 
    //         */
    //        Li li = new Li();
    //
    //        /** 
    //         * new 一个小王 
    //         */
    //        Wang wang = new Wang(li);
    //
    //        /** 
    //         * 小王问小李问题 
    //         */
    //        wang.askQuestion("1 + 1 = ?");
    //    }

    public static void main(String[] args) {
        //        Caller caller = new Caller();
        //        caller.setCallFunc(new CallBackImpl());
        //        caller.call();

        Caller caller = new Caller();
        //      caller.setCallFunc(new Client());
        caller.setCallFunc(new CallBack() {
            @Override
            public void solve(String result) {
                System.out.println("This is the client printName method");
            }
        });
        caller.call();
    }

}
