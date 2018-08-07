/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2017 All Rights Reserved.
 */
package com.huoli.checkin.util;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 *
 * @author Administrator
 * @version $Id: Person.java, v 0.1 2017年3月13日 下午1:35:19 Administrator Exp $
 */
public class Person implements Cloneable{

    private String name;

    private int    age;

    /**
     * Getter method for property <tt>name</tt>.
     * 
     * @return property value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter method for property <tt>name</tt>.
     * 
     * @param name value to be assigned to property name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter method for property <tt>age</tt>.
     * 
     * @return property value of age
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter method for property <tt>age</tt>.
     * 
     * @param age value to be assigned to property age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 
     */
    public Person() {
        // TODO Auto-generated constructor stub
    }

    /** 
     * @return
     * @throws CloneNotSupportedException
     * @see java.lang.Object#clone()
     */
    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
        }
        return null;
    }

    /** 
     * @return
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).toString();
    }

}
