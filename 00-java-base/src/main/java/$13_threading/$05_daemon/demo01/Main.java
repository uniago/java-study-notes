package $13_threading.$05_daemon.demo01;

public class Main {
    public static void main(String[] args) {
        Thread t = new TimerThread();
        t.setDaemon(true);
        t.start();
        try {
            Thread.sleep(1000 * 10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread exit");
    }
}
