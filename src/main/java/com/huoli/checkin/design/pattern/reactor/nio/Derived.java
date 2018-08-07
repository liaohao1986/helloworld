package com.huoli.checkin.design.pattern.reactor.nio;

public class Derived extends Base {
    public String whenAmISet = "set when declared";

    @Override
    void preProcess() {
        System.out.println("Derived preProcess()");
        whenAmISet = "set in preProcess()";
    }
}