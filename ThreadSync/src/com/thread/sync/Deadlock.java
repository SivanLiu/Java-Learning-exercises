package com.thread.sync;

/**
 * 死锁：
 * 1、交叉锁可导致程序出现死锁
 * 2、内存不足
 * 3、一问一答式的数据交换
 * 4、数据库锁
 * 5、文件锁
 * 6、死循环引起的死锁
 */
public class Deadlock {
    private final Object MUTEX_READ = new Object();
    private final Object MUTEX_WRITE = new Object();

    public void read() {
        synchronized (MUTEX_READ) {
            System.out.println(Thread.currentThread().getName() + " get READ lock");
            synchronized (MUTEX_WRITE) {
                System.out.println(Thread.currentThread().getName() + " get WRITE lock");
            }
            System.out.println(Thread.currentThread().getName() + " release WRITE lock");
        }
        System.out.println(Thread.currentThread().getName() + " release READ lock");
    }

    public void write() {
        synchronized (MUTEX_WRITE) {
            System.out.println(Thread.currentThread().getName() + " get WRITE lock");
            synchronized (MUTEX_READ) {
                System.out.println(Thread.currentThread().getName() + " get READ lock");
            }
            System.out.println(Thread.currentThread().getName() + " release READ lock");
        }
        System.out.println(Thread.currentThread().getName() + " release WRITE lock");
    }
}
