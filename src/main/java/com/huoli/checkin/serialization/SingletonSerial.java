/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Administrator
 * @version $Id: SimpleSerial.java, v 0.1 2017年3月14日 下午9:42:10 Administrator Exp $
 */
public class SingletonSerial {

    /**
     *
     * @param args
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws Exception {
        File file = new File("singleton.out");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        Singleton singleton = Singleton.getInstance();
        oout.writeObject(singleton);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newSingleton = oin.readObject(); // 没有强制转换到Person类型  
        oin.close();
        ObjectInputStream oin2 = new ObjectInputStream(new FileInputStream(file));
        Object newSingleton2 = oin2.readObject(); // 没有强制转换到Person类型  
        oin2.close();
        System.out.println(newSingleton);
        System.out.println(newSingleton2);
    }

}
