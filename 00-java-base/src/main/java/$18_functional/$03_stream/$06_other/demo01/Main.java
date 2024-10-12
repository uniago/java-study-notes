package $18_functional.$03_stream.$06_other.demo01;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(sort());
        System.out.println(sortIgnoreCase());
        System.out.println(distinct());
        concat();
        flatMap();
        parallel();
    }

    private static List<String> sort() {
        return List.of("Orange", "apple", "Banana")
            .stream()
            .sorted()
            .collect(Collectors.toList());
    }
    private static List<String> sortIgnoreCase() {
        return List.of("Orange", "apple", "Banana")
                .stream()
                .sorted(String::compareToIgnoreCase)
                .collect(Collectors.toList());
    }

    private static List<String> distinct() {
        return List.of("A", "B", "A", "C", "B", "D")
                .stream()
                .distinct()
                .collect(Collectors.toList()); // [A, B, C, D]
    }

    private static void concat() {
        Stream<String> s1 = List.of("A", "B", "C").stream();
        Stream<String> s2 = List.of("D", "E").stream();
        // 合并:
        Stream<String> s = Stream.concat(s1, s2);
        System.out.println(s.collect(Collectors.toList())); // [A, B, C, D, E]
    }

    private static void flatMap() {
        Stream<List<Integer>> s = Stream.of(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9));
        Stream<Integer> i = s.flatMap(list -> list.stream());
        i.forEach(System.out::println);
    }

    private static void parallel() {
        Stream<Integer> s = Stream.of(4,1,4,5,6,1,3,1,23,34,51,14,5);
        Integer[] result = s.parallel() // 变成一个可以并行处理的Stream
                .sorted() // 可以进行并行排序
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(result));
    }
}