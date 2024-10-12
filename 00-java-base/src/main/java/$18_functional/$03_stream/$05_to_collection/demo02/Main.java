package $18_functional.$03_stream.$05_to_collection.demo02;

import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Apple", "", null, "Pear", "  ", "Orange");
        List<String> list = stream.filter(s -> s != null && !s.isBlank()).collect(Collectors.toList());
        String[] array = list.stream().toArray(String[]::new);
        System.out.println(list);
    }
}