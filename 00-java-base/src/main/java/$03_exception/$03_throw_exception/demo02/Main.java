package $03_exception.$03_throw_exception.demo02;

// exception
public class Main {
    public static void main(String[] args) {
        try {
            process1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void process1() {
        try {
            process2();
        } catch (NullPointerException e) {
            // throw new IllegalArgumentException();
            // 把原始的Exception实例传进去，新的Exception就可以持有原始Exception信息
            throw new IllegalArgumentException(e);
        }
    }

    static void process2() {
        throw new NullPointerException();
    }
}