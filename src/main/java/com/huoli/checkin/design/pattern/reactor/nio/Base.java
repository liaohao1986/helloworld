package com.huoli.checkin.design.pattern.reactor.nio;

public class Base {
    Base() {
        System.out.println("Base construct()");
        preProcess();
    }

    void preProcess() {
        System.out.println("preProcess()");
    }
}
