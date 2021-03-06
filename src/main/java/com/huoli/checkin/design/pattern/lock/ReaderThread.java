package com.huoli.checkin.design.pattern.lock;

public class ReaderThread extends Thread {

    private final Data data;

    public ReaderThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        while (true) {
            long begin = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                String result = data.read();
                System.out.println(Thread.currentThread().getName() + " => " + result);
            }
            long time = System.currentTimeMillis() - begin;
            System.out.println(Thread.currentThread().getName() + " -- " + time + "ms");
        }
    }
}
