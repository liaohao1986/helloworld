/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.serialization;

import java.util.Arrays;

/**
 *
 * @author Administrator
 * @version $Id: InstanceEnum.java, v 0.1 2017年3月15日 上午8:22:38 Administrator Exp $
 */
public enum InstanceEnum {

    INSTANCE;

    private final static String[] favoriteSongs = { "1", "2" };

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

}
