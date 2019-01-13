package com.thread;

import java.util.stream.IntStream;

public class Main {

    private final static String PREFIX = "ALEX-";

    public static void main(String[] args) {
        final TicketWindowRunnable task = new TicketWindowRunnable();

        Thread windowThread1 = new Thread(task, "一号窗口");
        Thread windowThread2 = new Thread(task, "二号窗口");
        Thread windowThread3 = new Thread(task, "三号窗口");
        Thread windowThread4 = new Thread(task, "四号窗口");

        windowThread1.start();
        windowThread2.start();
        windowThread3.start();
        windowThread4.start();

        //线程命名
        IntStream.range(0, 5).mapToObj(Main::createThread).forEach(Thread::start);

        //在构造 Thread 的时候没有显式指定一个 ThreadGroup, 那么子线程将会被加入父线程所在的线程组，同时还会和父线程拥有同样的优先级，同样的 Daemon
        Thread t1 = new Thread("t1");
        ThreadGroup group = new ThreadGroup("TestGroup");
        Thread t2 = new Thread(group, "t2");

        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("Main thread belong group: " + mainThreadGroup.getName());
        System.out.println("t1 and main belong the same group: " + (mainThreadGroup == t1.getThreadGroup()));
        System.out.println("t2 thread group not belong main group: " + (mainThreadGroup == t2.getThreadGroup()));
        System.out.println("t2 thread group belong main TestGroup: " + (group == t2.getThreadGroup()));

//        if (args.length < 1) {
//            System.out.println("Please enter the stack size");
//            System.exit(1);
//        }

        //指定 Thread 的 stacksize 大小，stacksize 越大则递归深度越大
        ThreadGroup group1 = new ThreadGroup("TestGroup1");
        Runnable runnable = new Runnable() {
            final int MAX = Integer.MAX_VALUE;

            @Override
            public void run() {
                int i = 0;
                recurse(i);

            }

            private void recurse(int i) {
                System.out.println(i);
                if (i < MAX) {
                    recurse(i + 1);
                }
            }

        };

        Thread thread = new Thread(group1, runnable, "Test", 100000000);
        thread.start();

    }

    private static Thread createThread(final int intName) {
        return new Thread(() -> System.out.println(Thread.currentThread().getName()), PREFIX + intName);
    }
}
