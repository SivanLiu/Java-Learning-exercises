package com.single.mode;

/**
 * 饿汉式的单例设计模式在类初始化的时候会被收集进<clint>方法中，完全可以保证同步，在多线程的情况下，不会被实例化两次，但是创建的实例
 * 被 classloader 加载后可能很长一段时间后才被使用，导致实例类在堆内存的驻留更久的时间，无法进行懒加载
 */
public class HungrySingleMode {

    public byte[] data = new byte[1024];

    //在定义实例对象的时候直接初始化
    private static HungrySingleMode hungrySingleMode = new HungrySingleMode();

    //私有构造函数，不允许外部 new
    private HungrySingleMode() {

    }

    public static HungrySingleMode getHungrySingleMode() {
        return hungrySingleMode;
    }

}
