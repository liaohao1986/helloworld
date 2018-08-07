package com.huoli.checkin.jvm;

import java.lang.reflect.Field;

import sun.misc.Unsafe;

/** 
 * -Xms20M -XX:MaxDirectMemorySize=10M 
 * @author Nicholas 
 * 
 */
public class DirectMemoryOOM {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        // TODO Auto-generated method stub  
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = null;
        try {
            unsafe = (Unsafe) unsafeField.get(null);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }

}
