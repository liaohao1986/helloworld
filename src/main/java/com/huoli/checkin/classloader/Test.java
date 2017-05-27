package com.huoli.checkin.classloader;

public class Test {

    public Test() {
        System.out.println(this.getClass().getClassLoader().toString());
    }

}