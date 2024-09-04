package $07_collection.$02_list.demo03;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    public static void test01() {
        List<String> list = List.of("apple", "pear", "banana");
        Object[] array = list.toArray();
        for (Object s : array) {
            System.out.println(s);
        }
    }

    public static void test02() {
        List<Integer> list = List.of(12, 34, 56);
        Integer[] array = list.toArray(new Integer[3]);
        for (Integer n : array) {
            System.out.println(n);
        }
    }

    public static void test03() {
        List<Integer> list = List.of(12, 34, 56);
        Number[] array = list.toArray(new Number[3]);
        // Integer[] array = list.toArray(new Integer[list.size()]);
        // Integer[] array = list.toArray(Integer[]::new);
        for (Number n : array) {
            System.out.println(n);
        }
    }
}