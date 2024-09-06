package $13_threading.$06_synchronize.$05_condition.demo01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TaskQueue {
    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();
    private Queue<String> queue = new LinkedList<>();

    public void addTask(String s) {
        lock.lock();
        try {
            queue.add(s);
            condition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public String getTask() {
        lock.lock();
        try {
            // 可以自己醒
            // if (condition.await(1, TimeUnit.SECONDS)) {
            //     // 被其他线程唤醒
            // } else {
            //     // 指定时间内没有被其他线程唤醒
            // }
            while (queue.isEmpty()) {
                condition.await();
            }
            return queue.remove();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}