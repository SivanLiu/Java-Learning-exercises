class JoinThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("thread : " + Thread.currentThread().getName() + " --i: " + i);
        }
    }
}

public class Test {
    public static void main(String[] args) {
        JoinThread joinThread1 = new JoinThread();
        Thread thread1 = new Thread(joinThread1);
        Thread thread2 = new Thread(joinThread1);

        thread1.start();

        try {
            thread1.join();
            thread2.start();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("main : " + Thread.currentThread().getName() + " --i: " + i);
        }
    }
}
