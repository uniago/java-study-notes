package $07_collection.$02_list.demo02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> list = List.of("apple", "pear", "banana");
        test01(list);
        test02(list);
        test03(list);
    }

    public static void test01(List<String> list) {
        for (int i=0; i<list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }

    public static void test02(List<String> list) {
        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
            String s = it.next();
            System.out.println(s);
        }
    }

    public static void test03(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
}