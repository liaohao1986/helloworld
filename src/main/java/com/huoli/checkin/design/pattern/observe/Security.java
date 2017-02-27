package com.huoli.checkin.design.pattern.observe;

public class Security implements Observer {

    @Override
    public void update() {
        System.out.println("运输车有行动，保安贴身保护");  
    }
}
