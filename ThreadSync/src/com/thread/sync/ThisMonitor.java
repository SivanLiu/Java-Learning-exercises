package com.thread.sync;

import java.util.concurrent.TimeUnit;

/**
 * synchronized 同步某个类的不同静态方法或者非静态方法争抢的都是同一个 monitor 的 lock
 */
public class ThisMonitor {
    public static synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " enter to method1");
        try {
            TimeUnit.MINUTES.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " enter to method2");
        try {
            TimeUnit.MINUTES.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
