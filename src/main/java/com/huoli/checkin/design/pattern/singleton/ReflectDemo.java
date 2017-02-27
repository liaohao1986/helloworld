package com.huoli.checkin.design.pattern.singleton;

import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) throws Exception {
        Method method = PackageClazz.class.getDeclaredMethod("privilegedMethod", new Class[] { String.class, String.class });
        method.setAccessible(true);
        method.invoke(new PackageClazz(), "452345234", "q31234132");
    }
}

class PackageClazz {
    private void privilegedMethod(String invokerName, String adb) {
        System.out.println("---" + invokerName + "----" + adb);
    }
}
