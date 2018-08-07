/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.design.concurrent;

import java.util.concurrent.TimeUnit;

/**
 *
 * @author Administrator
 * @version $Id: StopThread.java, v 0.1 2017年4月23日 上午10:43:31 Administrator Exp $
 */
public class StopThread {

    private static boolean stopRequest = false;

    /**
     *
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                if (!stopRequest) {
                    System.out.println(i);
                    i++;
                }
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(5);
        stopRequest = true;

    }

}
