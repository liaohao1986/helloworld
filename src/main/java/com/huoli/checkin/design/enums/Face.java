/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.design.enums;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Maps;

/**
 *
 * @author Administrator
 * @version $Id: Face.java, v 0.1 2017年5月1日 上午10:11:42 Administrator Exp $
 */
public class Face {

    enum Suit {
        CLUB, DIAMOND, HEART
    };

    enum Rank {
        ACE, DEUCE, THREE, FOUR
    };

    public static void main(String[] args) {
        List<Suit> suits = Arrays.asList(Suit.values());
        List<Rank> ranks = Arrays.asList(Rank.values());
        Map<Integer, Integer> maps = Maps.newHashMap();

        Random r = new Random();
        int size = 200;
        //        for (int i = 0; i < size; i++) {
        //            int randomInt = r.nextInt(size);
        //            maps.put(randomInt, randomInt);
        //            System.out.println(r.nextInt(size));
        //        }
        System.out.println("map size=" + maps.size());
        System.out.println(1 - 9 * .10);
        BigDecimal b = new BigDecimal(1);
        //        r.nextInt();
        //        for (Iterator<Suit> i = suits.iterator(); i.hasNext();) {
        //            Suit suit = i.next();
        //            for (Iterator<Rank> j = ranks.iterator(); j.hasNext();) {
        //                System.out.println(suit + ";" + j.next());
        //            }
        //        }
    }
}
