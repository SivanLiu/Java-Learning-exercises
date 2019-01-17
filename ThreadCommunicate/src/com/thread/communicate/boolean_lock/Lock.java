package com.thread.communicate.boolean_lock;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface Lock {
    /**
     * lock 方法永远阻塞
     * @throws InterruptedException
     */
    void lock() throws InterruptedException;

    /**
     * 可被中断，也可增加对应的超时功能
     * @param mills
     * @throws InterruptedException
     * @throws TimeoutException
     */
    void lock(long mills) throws InterruptedException, TimeoutException;

    /**
     * 解锁
     */
    void unlock();

    /**
     * 获取当前有哪些线程被阻塞
     * @return
     */
    List<Thread> getBlockedThreads();
}
