package $13_threading.$06_synchronize.$01_sync_method.demo01;

public class Main {
    public static void main(String[] args) {
        var c1 = new Counter();
        var c2 = new Counter();

        // 对c1进行操作的线程:
        new Thread(() -> {
            c1.add(1);
        }).start();
        new Thread(() -> {
            c1.dec(1);
        }).start();

        // 对c2进行操作的线程:
        new Thread(() -> {
            c2.add(1);
        }).start();
        new Thread(() -> {
            c2.dec(1);
        }).start();

        System.out.println("c1.get() = " + c1.get());
        System.out.println("c2.get() = " + c2.get());
    }
}
