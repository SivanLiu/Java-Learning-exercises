package com.thread;

/**
 * 创建线程只有一种方式，就是构造 Thread 类，而实现线程的执行单元则有两种方式：
 * 1、重写 Thread 的 run 方法
 * 2、实现 Runnable 接口的 run 方法，并且将 Runnable 实例用作构造 Thread 的参数
 *
 * 两种方式的不同点在于重写 Thread 类的 run 方法是不能共享的，而使用 Runnable 接口则很容易实现同一个 Runnable 的实例构造不同的 Thread 实例
 */
public class TicketWindowRunnable implements Runnable {

    private int index = 1;

    private final static int MAX = 50;

    @Override
    public void run() {

        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码是 ：" + (index++));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
