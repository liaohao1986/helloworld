/**
 * 
 */
package com.huoli.checkin.serialization;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class Singleton implements Serializable {

    /** */
    private static final long serialVersionUID = -4700360891583535500L;

    private Singleton() {
    }

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

    private Object readResolve() {
        return instance;
    }

}
