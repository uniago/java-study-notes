package $03_exception.$03_throw_exception.demo05;

// exception
public class Main {
    public static void main(String[] args) throws Exception {
        Exception origin = null;
        try {
            System.out.println(Integer.parseInt("abc"));
        } catch (Exception e) {
            origin = e;
            throw e;
        } finally {
            Exception e = new IllegalArgumentException();
            // 添加原始异常, 以免被屏蔽异常
            if (origin != null) {
                e.addSuppressed(origin);
            }
            throw e;
        }
    }
}