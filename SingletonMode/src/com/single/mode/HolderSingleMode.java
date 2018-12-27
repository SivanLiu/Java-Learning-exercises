package com.single.mode;

/**
 * Holder 方式：
 *
 * 在 HolderSingleMode 中并没有 holderSingleMode 的静态成员，而是将其放到了静态内部类 Holder 中，因此 HolderSingleMode 类的初始化并不会直接创建 HolderSingleMode 实例，
 * Holder 类中定义了 HolderSingleMode 的静态变量，并且直接进行了初始化，当 Holder 被主动调用的时候则会创建 HolderSingleMode 实例，HolderSingleMode 实例的创建过程在 Java
 * 程序编译时期收集至 <clinit>() 方法中，该方法又是同步方法，同步方法可以保证内存的可见性，JVM 指令的顺序性和原子性。
 *
 * 单例设计模式中最好的一种，也被广泛只用
 */
public class HolderSingleMode {
    private HolderSingleMode() {

    }

    //在静态类中持有 HolderSingleMode 的实例，并且可被直接初始化
    private static class Holder {
        private static HolderSingleMode holderSingleMode = new HolderSingleMode();
    }

    public static HolderSingleMode getHolderSingleMode() {
        return Holder.holderSingleMode;
    }
}
