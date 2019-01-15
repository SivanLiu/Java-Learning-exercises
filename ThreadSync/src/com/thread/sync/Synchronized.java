package com.thread.sync;

import java.util.concurrent.TimeUnit;

/**
 * 1、synchronized 提供了一种锁的机制，能够确保共享变量的互斥访问，从而防止数据不一致的出现；
 * 2、synchronized 关键字包括 monitor enter 和 monitor exit 两个 JVM 指令，它能够保证在任何时候任何线程执行到
 * monitor enter 成功之前都必须从主存中获取数据，而不是缓存中，在 monitor enter 运行成功之后，共享变量被更新后的值
 * 必须刷入主内存
 * 3、synchronized 的指令严格遵守 java happen-before 规则，一个 monitor exit 指令之前必定要有一个 monitor enter
 *  - MonitorEnter: 每个对象都与一个 monitor 关联，一个 monitor 的 lock 锁只能被一个线程在同一时间获得，在一个线程
 *  尝试获得与对象关联 monitor 的所有权时会发生如下的几件事情。
 *  1）如果 monitor 的计数器为 0，则意味着该 monitor 的 lock 还没有被获得，某个线程获得之后将立即对该计数器加一，从此
 *  该线程就是这个 monitor 的所有者了；
 *  2）如果一个已经拥有 monitor 所有权的线程重入，则会导致 monitor 计数器在此累加；
 *  3）如果 monitor 已经被其他线程所拥有，则其他线程尝试获取该 monitor 的所有权时，会被陷入阻塞状态直到 monitor 计数器
 *  变为 0，才能再次尝试获取对 monitor 的所有权。
 *  - MonitorExit: 释放对 monitor 的所有权，想要释放某个对象关联的 monitor 的所有权的前提是，你曾经获得了所有权。释放
 *  monitor 所有权的过程比较简单，就是讲 monitor 的计数器减一，如果计数器的结果为 0，那就意味着该线程不再拥有对该 monitor
 *  的所有权，通俗地讲就是解锁。与此同时，被该 monitor block 的线程将再次尝试获得对该 monitor 的所有权
 */
public class Synchronized {
    private static final Object MUTEX = new Object();

    private void accessResource() {
        synchronized (MUTEX) {
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testSync() {
        final Synchronized aSynchronized = new Synchronized();
        for (int i = 0; i < 5; i++) {
            new Thread(aSynchronized::accessResource).start();
        }
    }
}
