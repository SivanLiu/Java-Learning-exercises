package com.single.mode;

/**
 * 懒汉式+同步方法：对于懒汉式的实例化增加同步的约束就可以使得懒汉式变为数据的安全性，保证数据的同步性
 * 但是 synchronized 关键字的天生特性导致了 getLazySyncSingleMode 方法只能在同一时刻被一个线程访问，效率低下
 */
public class LazySyncSingleMode {

    private static LazySyncSingleMode lazySyncSingleMode = null;

    private LazySyncSingleMode() {

    }

    //加入同步控制，每次只能有一个线程进入
    public static synchronized LazySyncSingleMode getLazySyncSingleMode() {
        if (null == lazySyncSingleMode) {
            lazySyncSingleMode = new LazySyncSingleMode();
        }

        return lazySyncSingleMode;
    }
}
