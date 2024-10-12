package $18_functional.$03_stream.$01_create.demo03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.regex.Pattern;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Stream<Integer> natual = Stream.generate(new NatualSupplier());
        // 注意：无限序列必须先变成有限序列再打印:
        natual.limit(20).forEach(System.out::println);

        // test01();
        // test02();
        test03();
    }

    private static void test01() throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get("/path/to/file.txt"))) {
            lines.forEach(System.out::println);
        }
    }

    private static void test02() throws IOException {
        Pattern p = Pattern.compile("\\s+");
        Stream<String> s = p.splitAsStream("The quick brown fox jumps over the lazy dog");
        s.forEach(System.out::println);
    }

    private static void test03() {
        // 将int[]数组变为IntStream:
        IntStream is = Arrays.stream(new int[] { 1, 2, 3 });
        is.forEach(System.out::println);
        // 将Stream<String>转换为LongStream:
        LongStream ls = List.of("1", "2", "3").stream().mapToLong(Long::parseLong);
        ls.forEach(System.out::println);
    }
}

class NatualSupplier implements Supplier<Integer> {
    int n = 0;
    public Integer get() {
        n++;
        return n;
    }
}