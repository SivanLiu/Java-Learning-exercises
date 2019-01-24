package com.thread.group;

public class Main {
    public static void main(String[] args) {
//        ThreadGroup currentGroup = Thread.currentThread().getThreadGroup();
//        ThreadGroup group1 = new ThreadGroup("Group1");
//
//        System.out.println(group1.getParent() == currentGroup);
//
//        ThreadGroup group2 = new ThreadGroup(group1, "Group2");
//        System.out.println(group2.getParent() == group1);
//
//        ThreadGroup myGroup = new ThreadGroup("myGroup");
//
//        Thread thread = new Thread(myGroup, new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, "MyThread");
//
//        thread.start();
//
//        try {
//            TimeUnit.MILLISECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
//
//        Thread[] list = new Thread[mainGroup.activeCount()];
//        //将 threadGroup 中的 active 线程全部复制到 Thread 数组中，其中 recurse 参数如果为 true，则会将所有子 group 中的 active 线程都递归加到 Thread 数组中
//        int recurseSize = mainGroup.enumerate(list);
//
//        System.out.println(recurseSize);
//
//        recurseSize = mainGroup.enumerate(list, false);
//        System.out.println(recurseSize);

        //复制 ThreadGroup 数组
//        ThreadGroup myGroup1 = new ThreadGroup("MyGroup1");
//        ThreadGroup myGroup2 = new ThreadGroup(myGroup1, "MyGroup2");
//
//        try {
//            TimeUnit.MILLISECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        ThreadGroup myMainGroup = Thread.currentThread().getThreadGroup();
//        ThreadGroup[] groups = new ThreadGroup[myMainGroup.activeGroupCount()];
//
//        int myRecurseSize = myMainGroup.enumerate(groups);
//        System.out.println(myRecurseSize);
//
//        myRecurseSize = myMainGroup.enumerate(groups, true);
//        System.out.println(myRecurseSize);

//        ThreadGroup group = new ThreadGroup("group1");
//
//        Thread thread = new Thread(group, new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, "thread");
//        thread.setDaemon(true);
//        thread.start();
//
//        try {
//            TimeUnit.MILLISECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
//
//        System.out.println("activeCount = " + mainGroup.activeCount());
//        System.out.println("activeGroupCount = " + mainGroup.activeGroupCount());
//        System.out.println("getMaxPriority = " + mainGroup.getMaxPriority());
//        System.out.println("getName = " + mainGroup.getName());
//        System.out.println("getParent = " + mainGroup.getParent());
//        mainGroup.list();
//        System.out.println("========================================");
//        System.out.println("parentOf = " + mainGroup.parentOf(group));
//        System.out.println("parentOf = " + mainGroup.parentOf(mainGroup));

        //interrupt 一个 thread group 会导致该 group 中所有 active 线程都被 interrupt
//        ThreadGroup group = new ThreadGroup("TestGroup");
//        new Thread(group, new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(2);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        break;
//                    }
//                }
//                System.out.println("t1 will exit. ");
//            }
//        }, "t1").start();
//
//        new Thread(group, new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    try {
//                        TimeUnit.MILLISECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        break;
//                    }
//                }
//                System.out.println("t2 will exit. ");
//            }
//        }, "t2").start();
//
//        try {
//            TimeUnit.MILLISECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        group.interrupt();

        //destroy 只是针对一个没有任何 active 线程的 group 进行一次 destroy 标记，该方法会在父 group 中将自己移除
//        ThreadGroup group = new ThreadGroup("TestGroup");
//
//        ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
//        System.out.println("group is destroyed = " + group.isDestroyed());
//        mainGroup.list();
//
//        group.destroy();
//
//        System.out.println("group is destroyed = " + group.isDestroyed());
//        mainGroup.list();


        //将 ThreadGroup设置为守护线程，不会影响线程的 daemon 属性，将 ThreadGroup 的 daemon 属性设置为 true, 那么在 group 中没有任何 active 线程的时候该 group 将自动 destroy
//        ThreadGroup group = new ThreadGroup("group1");
//        new Thread(group, new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"group-thread").start();
//
//        ThreadGroup group2 = new ThreadGroup("group1");
//        new Thread(group2, new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    TimeUnit.SECONDS.sleep(1);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        },"group2-thread").start();
//
//        group2.setDaemon(true);
//
//        try {
//            TimeUnit.SECONDS.sleep(3);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        System.out.println(group.isDestroyed());
//        System.out.println(group2.isDestroyed());

    }
}
