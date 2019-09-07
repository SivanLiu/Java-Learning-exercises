class ThreadTrain2 implements Runnable {

    private int count = 100;
    public boolean flag = true;
    private static Object oj = new Object();

    @Override
    public void run() {
        if (flag) {
            while (count > 0) {
                synchronized (this) {
                    if (count > 0) {
                        try {
                            Thread.sleep(50);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        System.out.println(Thread.currentThread().getName() + ", 出售第 " + (100 - count + 1) + " 票");
                        count--;
                    }
                }
            }
        } else {
            while (count > 0) {
                sale();
            }
        }

    }

    public synchronized void sale() {

        if (count > 0) {
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ", 出售第 " + (100 - count + 1) + " 票");
            count--;
        }
    }

}

public class TrainTicket {
    public static void main(String[] args) throws InterruptedException {
        ThreadTrain2 threadTrain2 = new ThreadTrain2();
        Thread thread1 = new Thread(threadTrain2, "1号窗口");
        Thread thread2 = new Thread(threadTrain2, "2号窗口");
        thread1.start();
        Thread.sleep(50);
        threadTrain2.flag = false;
        thread2.start();
    }
}
