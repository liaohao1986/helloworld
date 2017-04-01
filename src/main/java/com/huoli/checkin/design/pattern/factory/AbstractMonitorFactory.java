/**
 * 
 */
package com.huoli.checkin.design.pattern.factory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.http.annotation.ThreadSafe;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.monitor.Monitor;

@ThreadSafe
public abstract class AbstractMonitorFactory implements MonitorFactory {

    private static final Map<String, Monitor> MONITORS = new ConcurrentHashMap<String, Monitor>();

    private static final Lock LOCK = new ReentrantLock();

    public Monitor getMonitor(URL url) {
        String key = url.toServiceString();
        LOCK.lock();
        try {
            Monitor monitor = MONITORS.get(key);
            if (monitor != null) {
                return monitor;
            }
            monitor = createMonitor(url);
            if (monitor == null) {
                throw new IllegalStateException("Can not create monitor " + url);
            }
            MONITORS.put(key, monitor);
            return monitor;
        } finally {
            LOCK.unlock();
        }
    }

    abstract protected Monitor createMonitor(URL url);

}
