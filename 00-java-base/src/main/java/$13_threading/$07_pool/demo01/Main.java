package $13_threading.$07_pool.demo01;// thread-pool
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        // testFixedThreadPool();
        // testCachedThreadPool();
        // testScheduledThreadPool();
        // testSchedule();
        // testFixedRate();
        testFixedDelay();
    }

    public static void testFixedThreadPool() {
        // 创建一个固定大小的线程池:
        ExecutorService es = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // 关闭线程池:
        es.shutdown();
    }

    public static void testCachedThreadPool() {
        int min = 4;
        int max = 10;
        ExecutorService es = new ThreadPoolExecutor(
                min, max,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<Runnable>());
        for (int i = 0; i < 6; i++) {
            es.submit(new Task("" + i));
        }
        // 关闭线程池:
        es.shutdown();
    }

    public static void testScheduledThreadPool() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        for (int i = 0; i < 6; i++) {
            ses.submit(new Task("" + i));
        }
        // 关闭线程池:
        ses.shutdown();
    }

    public static void testSchedule() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        ses.schedule(new Task("one-time"), 1, TimeUnit.SECONDS);
        ses.shutdown();
    }

    public static void testFixedRate() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        // 2秒后开始执行定时任务，每3秒执行:
        ses.scheduleAtFixedRate(new Task("fixed-rate"), 2, 3, TimeUnit.SECONDS);
        // ses.shutdown();
    }

    public static void testFixedDelay() {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(4);
        // 2秒后开始执行定时任务，以3秒为间隔执行:
        ses.scheduleWithFixedDelay(new Task("fixed-delay"), 2, 3, TimeUnit.SECONDS);
        // ses.shutdown();
    }
}

