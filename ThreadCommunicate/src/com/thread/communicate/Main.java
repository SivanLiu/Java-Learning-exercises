package com.thread.communicate;

import java.util.concurrent.TimeUnit;

public class Main {
    private synchronized void syncMethod() {
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Main main = new Main();
        Thread t1 = new Thread(main::syncMethod, "T1");
        t1.start();

        try {
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(main::syncMethod, "T2");
        t2.start();

        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.interrupt();

        System.out.println(t2.isInterrupted());
        System.out.println(t2.getState());
    }
}
