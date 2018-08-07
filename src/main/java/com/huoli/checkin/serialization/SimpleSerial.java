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
public class SimpleSerial {

    /**
     *
     * @param args
     * @throws IOException 
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws Exception {
        File file = new File("person.out");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream(file));
        //        Person person = new Person("John", 101, Gender.MALE);
//        oout.writeObject(Person.getInstance());InstanceEnum
        oout.writeObject(InstanceEnum.INSTANCE);
        oout.close();

        ObjectInputStream oin = new ObjectInputStream(new FileInputStream(file));
        Object newPerson = oin.readObject(); // 没有强制转换到Person类型  
        oin.close();
        
        ObjectInputStream oin2 = new ObjectInputStream(new FileInputStream(file));
        Object newPerson2 = oin2.readObject(); // 没有强制转换到Person类型  
        oin2.close();
        
        System.out.println(newPerson);
        System.out.println(InstanceEnum.INSTANCE == newPerson); // 将获取的对象与Person类中的单例对象进行相等性比较
        System.out.println(newPerson == newPerson2); 
    }

}
