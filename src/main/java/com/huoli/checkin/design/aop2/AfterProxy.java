package com.huoli.checkin.design.aop2;

import java.lang.reflect.Method;

public class AfterProxy extends AbstractProxy {

    @Override
    public void after(Class<?> cls, Method method, Object[] params) {
        super.after(cls, method, params);
        System.out.println("After");
    }

}
