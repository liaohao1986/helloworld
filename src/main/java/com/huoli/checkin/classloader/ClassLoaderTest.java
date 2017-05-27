package com.huoli.checkin.classloader;

import java.io.InputStream;

public class ClassLoaderTest {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        ClassLoader loader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                // TODO Auto-generated method stub  
                try {
                    String className = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(className);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] buffer = new byte[is.available()];
                    is.read(buffer);
                    return defineClass(name, buffer, 0, buffer.length);
                } catch (Exception e) {
                    // TODO: handle exception  
                    throw new ClassNotFoundException(name);
                }

            }
        };
        Object object = loader.loadClass("com.huoli.checkin.classloader.ClassLoaderTest").newInstance();
        System.out.println(object.getClass());
        System.out.println(object instanceof com.huoli.checkin.classloader.ClassLoaderTest);
    }
}
