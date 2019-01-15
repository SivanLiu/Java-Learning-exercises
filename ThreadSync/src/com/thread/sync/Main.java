package com.thread.sync;

public class Main {
    public static void main(String[] args) {
        Synchronized.testSync();

        ThisMonitor thisMonitor = new ThisMonitor();
        new Thread(ThisMonitor::method1, "T1").start();
        new Thread(ThisMonitor::method2, "T2").start();

        final Deadlock deadlock = new Deadlock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    deadlock.read();
                }
            }
        }, "READ-THREAD").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                deadlock.write();
            }
        }, "WRITE-THREAD").start();
    }
}

