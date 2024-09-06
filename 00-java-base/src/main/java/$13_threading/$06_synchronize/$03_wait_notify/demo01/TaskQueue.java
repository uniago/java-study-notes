package $13_threading.$06_synchronize.$03_wait_notify.demo01;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.Queue;

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notify(); // 唤醒在this锁等待的线程
    }

    public synchronized String getTask() {
        while (queue.isEmpty()) {
            System.out.println(LocalTime.now());
            try {
                // 释放this锁:
                this.wait();
                // 重新获取this锁
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return queue.remove();
    }

    public static void main(String[] args) {
        TaskQueue taskQueue = new TaskQueue();
        new Thread(() -> System.out.println(taskQueue.getTask())).start();

        new Thread(() -> taskQueue.addTask("task1")).start();
    }
}