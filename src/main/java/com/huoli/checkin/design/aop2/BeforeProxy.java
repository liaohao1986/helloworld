package com.huoli.checkin.design.aop2;

import java.lang.reflect.Method;

public class BeforeProxy extends AbstractProxy {

    @Override
    public void before(Class<?> cls, Method method, Object[] params) {
        super.before(cls, method, params);
        System.out.println("Before");
    }
    
}
