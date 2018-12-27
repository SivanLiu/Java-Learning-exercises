package com.single.mode;

import java.net.Socket;
import java.sql.Connection;

/**
 * 双重检查提供了高效的数据同步策略，可以允许多个线程同时对 doubleCheckSingleMode 访问，但这种方式在多线程的情况下可能会
 * 引起空指针的异常：
 *
 * 在 DoubleCheckSingleMode 构造函数中，需要分别实例化 connection、socket 两个资源以及 DoubleCheckSingleMode 自身，根据
 * JVM 运行时指令重排序和 Happens-Before 规则，这三者之间的实例化顺序并无前后约束，那么极有可能 DoubleCheckSingleMode 被实
 * 实例化，而 conn、socket 并未完成实例化，未完成实例化的实例调用将会抛出空指针异常。
 */
public class DoubleCheckSingleMode {
    private static DoubleCheckSingleMode doubleCheckSingleMode;
    Connection connection;
    Socket socket;

    //若在 doubleCheckSingleMode 后面执行则会引起空指针异常
    private DoubleCheckSingleMode() {
        this.connection = null;
        this.socket = null;
    }

    public static DoubleCheckSingleMode doubleCheckSingleMode() {
        //当实例为 null 时，进入同步代码块，同时该判断避免了每次都需要进入同步代码块，可以提高效率
        if (null == doubleCheckSingleMode) {
            //只有一个线程能够获得 DoubleCheckSingleMode.class 关联的 monitor
            synchronized (DoubleCheckSingleMode.class) {
                //判断如果 doubleCheckSingleMode 为空则创建
                if (null == doubleCheckSingleMode) {
                    doubleCheckSingleMode = new DoubleCheckSingleMode();
                }
            }
        }

        return doubleCheckSingleMode;
    }

}
