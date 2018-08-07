package com.huoli.checkin.design.pattern.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Data {

    private final char[] buffer;

    private final Lock   readLock  = new ReentrantLock(); // 创建读写锁
    private final Lock   writeLock = new ReentrantLock(); // 创建读写锁

    //    private final ReadWriteLock lock      = new ReentrantReadWriteLock(); // 创建读写锁
    //    private final Lock          readLock  = lock.readLock();             // 获取读锁
    //    private final Lock          writeLock = lock.writeLock();            // 获取写锁

    public Data(int size) {
        this.buffer = new char[size];
        for (int i = 0; i < size; i++) {
            buffer[i] = '*';
        }
    }

    public String read() {
//        readLock.lock();
//        try {
            return doRead();
//        } finally {
//            readLock.unlock();
//        }
    }

    public synchronized String doRead() {
        StringBuilder result = new StringBuilder();
        for (char c : buffer) {
            result.append(c);
        }
        sleep(100);
        return result.toString();
    }

    public void write(char c) {
//        writeLock.lock();
//        try {
            doWrite(c);
//        } finally {
//            writeLock.unlock();
//        }
    }

    public synchronized void doWrite(char c) {
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = c;
            sleep(100);
        }
    }

    private void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}