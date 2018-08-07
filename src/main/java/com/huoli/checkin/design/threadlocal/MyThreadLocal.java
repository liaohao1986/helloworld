package com.huoli.checkin.design.threadlocal;

import java.util.Map;

import com.google.common.collect.Maps;

public class MyThreadLocal<T> {

    private Map<Thread, T> container = Maps.newConcurrentMap();
    
//  private Map<Thread, T> container = Collections.synchronizedMap(new HashMap<Thread, T>());

    public void set(T value) {
        container.put(Thread.currentThread(), value);
    }

    public T get() {
        Thread thread = Thread.currentThread();
        T value = container.get(thread);
        if (value == null && !container.containsKey(thread)) {
            value = initialValue();
            container.put(thread, value);
        }
        return value;
    }

    public void remove() {
        container.remove(Thread.currentThread());
    }

    protected T initialValue() {
        return null;
    }
}
