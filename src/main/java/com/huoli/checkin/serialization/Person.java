/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 *
 * @author Administrator
 * @version $Id: Person.java, v 0.1 2017年3月14日 下午9:39:47 Administrator Exp $
 */
public class Person implements Serializable {

    /** */
    private static final long serialVersionUID = 3973699714266105844L;

    private static class InstanceHolder {
        private static final Person instatnce = new Person("John", 31, Gender.MALE);
    }

    public static Person getInstance() {
        return InstanceHolder.instatnce;
    }

    private Object readResolve() throws ObjectStreamException {
        return InstanceHolder.instatnce;
    }

    private String  name   = null;

    private Integer age    = null;

    private Gender  gender = null;

    private Person() {
        System.out.println("none-arg constructor");
    }

    private Person(String name, Integer age, Gender gender) {
        System.out.println("arg constructor");
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeInt(age);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        age = in.readInt();
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + "]";
    }
}