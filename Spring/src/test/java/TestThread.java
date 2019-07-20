import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;
import sun.awt.windows.ThemeReader;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RunWith(SpringRunner.class)
@SpringJUnitConfig
public class TestThread {

    private static Object lock1 = new Object();
    private static Object lock2 = new Object();

    @Test
    public void testThread() {
/*
        deadLock(lock1, lock2, 1000L, "线程1");
        deadLock(lock2, lock1, 1000L, "线程2");
*/
        threadPool();
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

    @Test
    public void executeMethod() {
        System.out.println(">>>>>>>>>>>>>>>>执行流程1");
        testAsync();
        System.out.println(">>>>>>>>>>>>>>>>执行流程4");
    }

    @Async
    public String testAsync(){
        System.out.println(">>>>>>>>>>>>>>>>>执行流程2");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(">>>>>>>>>>>>>>>>>执行流程3");
        return "success";
    }
}
