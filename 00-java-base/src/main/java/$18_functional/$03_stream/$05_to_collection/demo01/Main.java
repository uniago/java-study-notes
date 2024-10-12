package $18_functional.$03_stream.$05_to_collection.demo01;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args)     {
        Stream<Long> s1 = Stream.generate(new NatualSupplier());
        Stream<Long> s2 = s1.map(n -> n * n);
        Stream<Long> s3 = s2.map(n -> n - 1);
        System.out.println(s3); // java.util.stream.ReferencePipeline$3@49476842

        Stream<Long> s4 = s3.limit(10);
        s4.reduce(0L, (acc, n) -> acc + n);
    }
}

class NatualSupplier implements Supplier<Long> {
    long n = 0;
    public Long get() {
        n++;
        return n;
    }
}