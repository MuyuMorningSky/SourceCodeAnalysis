import sun.awt.windows.ThemeReader;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class TestThread {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    public static void main(String[] args) {
/*

        deadLock(lock1, lock2, 1000L, "线程1");
        deadLock(lock2, lock1, 1000L, "线程2");
*/
/*

        threadPool();
*/

        suspendAndResume(lock1, 1000L, "线程3");
        suspendAndResume(lock1, 0L, "线程4");
    }

    public static void deadLock(Object lock1, Object lock2, Long time, String threadName) {
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(threadName + "start");
                synchronized (lock2) {
                    System.out.println(threadName);
                }
            }
        }, "ThreadName").start();
    }

    public static void threadPool() {
        //线程池创建
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println("TheradPool创建线程：" + Thread.currentThread().getName());
        });
    }

    public static void suspendAndResume(Object lock1, Long time, String threadName) {
        new Thread(() -> {
            synchronized (lock1) {
                System.out.println(threadName+"start");
                Thread.currentThread().suspend();
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName+"end");
        },threadName).start();
        Thread.currentThread().resume();
    }

    public static void waitAndNotify() {

    }
}
