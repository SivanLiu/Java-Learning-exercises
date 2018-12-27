package com.single.mode;

/**
 * 懒汉式：在 getLazySingleMode 时候实例化，若在多线程情况下，lazySingleMode 则会被实例化多次，无法保证单例的唯一性
 */
public class LazySingleMode {

    private byte[] data = new byte[1024];

    //定义实例，但不直接初始化
    private static LazySingleMode lazySingleMode = null;

    private LazySingleMode() {

    }

    public static LazySingleMode getLazySingleMode() {
        if (null == lazySingleMode) {

            lazySingleMode = new LazySingleMode();
        }

        return lazySingleMode;
    }
}
