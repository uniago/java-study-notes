package $13_threading.$06_synchronize.$02_dead_lock.demo01;

public class Counter {
    private int count = 0;

    public synchronized void add(int n) {
        if (n < 0) {
            // 获取第二道锁, 叫重入锁
            dec(-n);
        } else {
            count += n;
        }
    }

    public synchronized void dec(int n) {
        count += n;
    }
}