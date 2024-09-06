package $13_threading.$02_new_thread.demo02;

// 多线程
public class Main {
    public static void main(String[] args) {
        Thread t = new MyThread();
        t.start(); // 启动新线程

        Thread t2 = new Thread(new MyRunnable());
        t2.start();

        Thread t3 = new Thread(() -> System.out.println("start new thread! 3"));
        t3.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("start new thread! 1");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("start new thread! 2");
    }
}