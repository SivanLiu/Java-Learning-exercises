package com.single.mode;

import java.net.Socket;
import java.sql.Connection;

/**
 * 针对于双重检查的缺陷，可以用 volatile 来防止指令重排序的发生，如此就可以满足多线程下的单例、懒加载以及获取实例的高效性
 */
public class VolatileDCSingleMode {
    private static volatile VolatileDCSingleMode volatileDCSingleMode;
    Connection connection;
    Socket socket;

    //若在 doubleCheckSingleMode 后面执行则会引起空指针异常
    private VolatileDCSingleMode() {
        this.connection = null;
        this.socket = null;
    }

    public static VolatileDCSingleMode getVolatileDCSingleMode() {
        //当实例为 null 时，进入同步代码块，同时该判断避免了每次都需要进入同步代码块，可以提高效率
        if (null == volatileDCSingleMode) {
            //只有一个线程能够获得 DoubleCheckSingleMode.class 关联的 monitor
            synchronized (DoubleCheckSingleMode.class) {
                //判断如果 doubleCheckSingleMode 为空则创建
                if (null == volatileDCSingleMode) {
                    volatileDCSingleMode = new VolatileDCSingleMode();
                }
            }
        }

        return volatileDCSingleMode;
    }
}
