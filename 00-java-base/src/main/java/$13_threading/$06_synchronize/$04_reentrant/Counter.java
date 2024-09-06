package $13_threading.$06_synchronize.$04_reentrant;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    private final Lock lock = new ReentrantLock();
    private int count;

    public void add(int n) {
        // synchronized(this) {
        //     count += n;
        // }

        // lock.lock();
        // try {
        //     count += n;
        // } finally {
        //     lock.unlock();
        // }

        try {
            // 可以尝试获取锁，最多等待1秒
            if (lock.tryLock(1, TimeUnit.SECONDS)) {
                try {
                    count += n;
                } finally {
                    lock.unlock();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}