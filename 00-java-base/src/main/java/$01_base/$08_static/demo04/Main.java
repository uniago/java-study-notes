package $01_base.$08_static.demo04;

public class Main {
    public static void main(String[] args) {
        new Person();
        new Person();
        new Person();
        System.out.println(Person.getCount());

        // 多线程下访问静态变量 出现的问题
        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                new Person();
                System.out.println(Thread.currentThread().getName() + ":" + Person.getCount());
            }
        }).start();

        // try {
        //     Thread.sleep(500);
        // } catch (InterruptedException e) {
        //     throw new RuntimeException(e);
        // }
        System.out.println(Thread.currentThread().getName() + ":" + Person.getCount());
    }
}

class Person {
    public static int count = 0;

    public Person() {
        count++;
    }

    public static int getCount() {
        return count;
    }
}
