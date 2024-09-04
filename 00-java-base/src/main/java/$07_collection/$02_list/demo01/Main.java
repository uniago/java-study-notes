package $07_collection.$02_list.demo01;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test01 () {
        List<String> list = new ArrayList<>();
        list.add("apple"); // size=1
        list.add("pear"); // size=2
        list.add("apple"); // 允许重复添加元素，size=3
        System.out.println(list.size());
    }

    public static void test02 () {
        List<String> list = new ArrayList<>();
        list.add("apple"); // size=1
        list.add(null); // size=2
        list.add("pear"); // size=3
        String second = list.get(1); // null
        System.out.println(second);
    }
}