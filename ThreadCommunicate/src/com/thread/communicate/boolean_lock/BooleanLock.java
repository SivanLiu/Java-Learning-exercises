package com.thread.communicate.boolean_lock;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.currentThread;

public class BooleanLock implements Lock {

    /**
     * 当前拥有锁的线程
     */
    private Thread currentThread;

    /**
     * false 表示当前该锁没有被任何线程获得或者已经释放
     * true 表示该锁已经被某个线程获得，该线程就是 currentThread
     */
    private boolean locked = false;

    /**
     * 存储哪些线程进入了阻塞状态
     */
    private final List<Thread> blokcedList = new ArrayList<>();

    /**
     * 如果当前锁已经被某个线程获得，则该线程将加入阻塞队列，并且使当前线程 wait 释放对
     * this monitor 的所有权
     * 如果当前锁没有被其他线程获得，则该线程将尝试从阻塞队列中删除自己；
     *
     * @throws InterruptedException
     */
    @Override
    public void lock() throws InterruptedException {
        synchronized (this) {
            while (locked) {
                final Thread tempThread = Thread.currentThread();
                try {
                    if (!blokcedList.contains(tempThread)) {
                        blokcedList.add(tempThread);
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    blokcedList.remove(tempThread);
                    throw e;
                }
            }

            blokcedList.remove(currentThread);
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    @Override
    public void lock(long mills) throws InterruptedException, TimeoutException {
        synchronized (this) {
            if (mills <= 0) {
                //若 mills 不合法，则默认调用 lock 方法
                this.lock();
            } else {
                long remainingMills = mills;
                long endMills = System.currentTimeMillis() + remainingMills;
                while (locked) {
                    // 如果 remainingMills 小于等于 0，则意味着当前线程被其他线程唤醒或者在指定的 wait 时间到了之后还没有获得锁，可抛出异常
                    if (remainingMills <= 0) {
                        throw new TimeoutException("can not get the lock during " + mills);
                    }

                    if (!blokcedList.contains(currentThread())) {
                        blokcedList.add(currentThread());
                        this.wait(remainingMills);
                        remainingMills = endMills - System.currentTimeMillis();
                    }

                    blokcedList.remove(currentThread());
                    this.locked = true;
                    this.currentThread = currentThread();
                }
            }
        }
    }

    @Override
    public void unlock() {
        synchronized (this) {
            if (currentThread == currentThread()) {
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock. ").ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    @Override
    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blokcedList);
    }
}
