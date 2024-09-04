package $07_collection.$05_hashcode.demo01;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String key1 = "a";
        Map<String, Integer> map = new HashMap<>();
        map.put(key1, 123);

        String key2 = new String("a");
        map.get(key2); // 123
        System.out.println(map.get(key2));

        System.out.println(key1 == key2); // false
        System.out.println(key1.equals(key2)); // true
    }
}