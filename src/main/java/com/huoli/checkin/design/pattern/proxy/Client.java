package com.huoli.checkin.design.pattern.proxy;

public class Client {
    private static Subject subject;

    static public void main(String[] args) {
        subject = new ProxySubject();
        RealSubject realSubject = new RealSubject();
        realSubject.request();
        subject.request();
    }
}
