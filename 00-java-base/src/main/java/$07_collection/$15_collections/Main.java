package $07_collection.$15_collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        // sort();
        // shuffle();
        // mutable();
        // immutable();
        immutable2();
    }
    public static void sort() {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pear");
        list.add("orange");
        // 排序前:
        System.out.println(list);
        Collections.sort(list);
        // 排序后:
        System.out.println(list);
    }

    public static void shuffle() {
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<10; i++) {
            list.add(i);
        }
        // 洗牌前:
        System.out.println(list);
        // 洗牌:
        Collections.shuffle(list);
        // 洗牌后:
        System.out.println(list);
    }

    public static void mutable() {
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        immutable.add("orange"); // UnsupportedOperationException!
    }

    public static void immutable() {
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        // 不影响原来的集合:
        mutable.add("orange");
        System.out.println(immutable);
    }

    public static void immutable2() {
        List<String> mutable = new ArrayList<>();
        mutable.add("apple");
        mutable.add("pear");
        // 变为不可变集合:
        List<String> immutable = Collections.unmodifiableList(mutable);
        // 推荐 立刻扔掉mutable的引用:
        mutable = null;
        System.out.println(immutable);
    }
}