package $11_reg_exp.$03_complex_match.demo01;

// regex
public class Main {
    public static void main(String[] args) {
        // test01();
        test02();
    }

    public static void test01() {
        String re = "java|php";
        System.out.println("java".matches(re));
        System.out.println("php".matches(re));
        System.out.println("go".matches(re));
    }

    public static void test02() {
        String re = "learn\\s(([jJ])ava|php|[gG]o)";
        System.out.println("learn java".matches(re));
        System.out.println("learn Java".matches(re));
        System.out.println("learn php".matches(re));
        System.out.println("learn Go".matches(re));
    }
}