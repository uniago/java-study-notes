package $13_threading.$06_synchronize.$02_dead_lock.demo02;

public class Main {
    public static void main(String[] args) {

        // 对c1进行操作的线程:
        new Thread(() -> {
            var c1 = new Counter();
            c1.add(1);
            c1.dec(1);
        }, "c1").start();

        // 对c2进行操作的线程:
        new Thread(() -> {
            var c2 = new Counter();
            c2.add(1);
            c2.dec(1);
        }, "c2").start();

    }
}

class Counter {
    private static final Object lockA = new Object();
    private static final Object lockB = new Object();
    private int value = 0;
    private int another = 0;

    public void add(int m) {
        synchronized(lockA) { // 获得lockA的锁

            // cpu执行太快
            // 睡1毫秒 模拟死锁
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.value += m;
            synchronized(lockB) { // 获得lockB的锁
                this.another += m;
            } // 释放lockB的锁
        } // 释放lockA的锁
        System.out.println(Thread.currentThread().getName() + ":add...");
    }

    public void dec(int m) {
        synchronized(lockB) { // 获得lockB的锁
            this.another -= m;
            synchronized(lockA) { // 获得lockA的锁
                this.value -= m;
            } // 释放lockA的锁
        } // 释放lockB的锁
        System.out.println(Thread.currentThread().getName() + ":dec...");
    }
}
